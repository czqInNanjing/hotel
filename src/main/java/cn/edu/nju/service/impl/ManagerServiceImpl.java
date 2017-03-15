package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.ManagerService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.Helper;
import cn.edu.nju.util.SystemDefault;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Qiang
 * @since 02/03/2017
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private final OpenApplicationRepository openApplicationRepository;
    private final ModifyApplicationRepository modifyApplicationRepository;
    private final HotelRepository hotelRepository;
    private final HotelNewRepository hotelNewRepository;
    private final SettlementRepository settlementRepository;
    private final HotelService hotelService;
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final LiveMesRepository liveMesRepository;


    @Autowired
    public ManagerServiceImpl(OpenApplicationRepository openApplicationRepository, ModifyApplicationRepository modifyApplicationRepository, HotelRepository hotelRepository, HotelNewRepository hotelNewRepository, SettlementRepository settlementRepository, HotelService hotelService, MemberRepository memberRepository, MemberService memberService, LiveMesRepository liveMesRepository) {
        this.openApplicationRepository = openApplicationRepository;
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.hotelRepository = hotelRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.settlementRepository = settlementRepository;
        this.hotelService = hotelService;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.liveMesRepository = liveMesRepository;
    }


    @Override
    public List<OpenApplicationEntity> getAllOpenApplication(boolean onlyOpen, int page) {

        List<OpenApplicationEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<OpenApplicationEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = openApplicationRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = openApplicationRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                openApplicationRepository.findByStatus(0).forEach(result::add);
            } else {
                openApplicationRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }

    @Override
    public List<ModifyApplicationEntity> getAllModifyApplication(boolean onlyOpen, int page) {
        List<ModifyApplicationEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<ModifyApplicationEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = modifyApplicationRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = modifyApplicationRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                modifyApplicationRepository.findByStatus(0).forEach(result::add);
            } else {
                modifyApplicationRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }

    @Override
    public List<SettlementEntity> getAllSettlements(boolean onlyOpen, int page) {
        List<SettlementEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<SettlementEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = settlementRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = settlementRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                settlementRepository.findByStatus(0).forEach(result::add);
            } else {
                settlementRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }


    @Override
    public Map<String, Object> approve(boolean approve, boolean openOrModify, List<Integer> applicationId) {
        int status = 0;
        if (approve) {
            status = 1;
        } else {
            status = 2;
        }
        final int finalStatus = status; // in lambda expression must be final or effectively final
        if (openOrModify) {
            Iterable<OpenApplicationEntity> openApplicationEntities = openApplicationRepository.findAll(applicationId);

            openApplicationEntities.forEach(entity -> {
                entity.setStatus(finalStatus);
                int id = entity.getHotelId();
                hotelRepository.findOne(id).setStatus(1);

            });
            openApplicationRepository.save(openApplicationEntities);
        } else {
            Iterable<ModifyApplicationEntity> modifyApplicationEntities = modifyApplicationRepository.findAll(applicationId);
            modifyApplicationEntities.forEach(modifyApplicationEntity -> {
                modifyApplicationEntity.setStatus(finalStatus);
                int id = modifyApplicationEntity.getHotelId();

                int newId = modifyApplicationEntity.getNewHotelId();
                HotelEntity hotelEntity = hotelRepository.findOne(id);
                HotelNewEntity hotelNewEntity = hotelNewRepository.findOne(newId);

                BeanUtils.copyProperties(hotelNewEntity,hotelEntity , "id" , "status");
            });
            modifyApplicationRepository.save(modifyApplicationEntities);
        }
        Map<String, Object> result = new TreeMap<>();
        result.put(SystemDefault.HTTP_RESULT, true);

        return result;
    }

    @Override
    public Map<String, Object> settle(boolean isApprove, List<Integer> operationArray) {
        Iterable<SettlementEntity> settlementEntities = settlementRepository.findAll(operationArray);
        int status = 0;
        if (isApprove) {
            status = 1;
        } else {
            status = 2;
        }
        final int finalStatus = status;
        settlementEntities.forEach(entity -> {
            entity.setStatus(finalStatus);

            //TODO what to do next if approved or not
        });
        settlementRepository.save(settlementEntities);
        Map<String, Object> result = new TreeMap<>();
        result.put(SystemDefault.HTTP_RESULT, true);

        return result;
    }

    @Override
    public Map<String, Object> getHotelStatus() {
        Map<String, Object> result = new TreeMap<>();

        List<HotelEntity> hotelEntities = hotelRepository.findByStatus(1);
        List<String> hotelNameList = new ArrayList<>(hotelEntities.size());
        List<Integer> reservedList = new ArrayList<>(hotelEntities.size());
        List<Integer> underUseList = new ArrayList<>(hotelEntities.size());
        List<Integer> availableList = new ArrayList<>(hotelEntities.size());

        int index = 0;
        for (HotelEntity hotelEntity : hotelEntities) {
            index++;
            if (index > 20) {
                break;
            }
            hotelNameList.add(hotelEntity.getName());
            List<Integer> status = hotelService.getRoomStatus(hotelEntity.getId());
            reservedList.add(status.get(0));
            underUseList.add(status.get(1));
            availableList.add(status.get(2));
        }
//        hotelEntities.forEach(hotelEntity -> {
//            hotelNameList.add(hotelEntity.getName());
//            List<Integer> status = hotelService.getRoomStatus(hotelEntity.getId());
//            reservedList.add(status.get(0));
//            underUseList.add(status.get(1));
//            availableList.add(status.get(2));
//        });

        result.put("hotelNameList", hotelNameList);
        result.put("reserved" , reservedList);
        result.put("underUse", underUseList);
        result.put("available" , availableList);


        result.put(SystemDefault.HTTP_RESULT, true);
        return result;
    }

    @Override
    public Map<String, Object> getMemberStatus() {
        Map<String, Object> result = new TreeMap<>();

        Iterable<MemberEntity> memberEntities = memberRepository.findAll();
        List<String> userId = new ArrayList<>();
        List<Integer> reservedTimeList = new ArrayList<>();
        List<Integer> liveTimeList = new ArrayList<>();
        List<Integer> rechargeTimeList = new ArrayList<>();

        int index = 0;
        for (MemberEntity memberEntity : memberEntities) {
            index++;
            if (index > 40) {
                break;
            }

            userId.add(String.format("%07d" , memberEntity.getId()));
            List<Integer> status = memberService.getMemberStatus(memberEntity.getId());
            reservedTimeList.add(status.get(0));
            liveTimeList.add(status.get(1));
            rechargeTimeList.add(status.get(2));
        }

//        memberEntities.forEach(memberEntity -> {
//            userId.add(String.format("%07d" , memberEntity.getId()));
//            List<Integer> status = memberService.getMemberStatus(memberEntity.getId());
//            reservedTimeList.add(status.get(0));
//            liveTimeList.add(status.get(1));
//            rechargeTimeList.add(status.get(2));
//        });
//


        result.put("userIdList", userId);
        result.put("reservedTime" , reservedTimeList);
        result.put("liveTime", liveTimeList);
        result.put("rechargeTime" , rechargeTimeList);


        result.put(SystemDefault.HTTP_RESULT, true);
        return result;
    }

    @Override
    public Map<String, Object> getFinanceStatus() {
        Map<String, Object> result = new TreeMap<>();

        List<String> date = new ArrayList<>();
        List<Integer> memberCardList = new ArrayList<>();
        List<Integer> cashList = new ArrayList<>();
        List<Integer> creditCardList = new ArrayList<>();

        Map<String, Integer> memberCardMap = new TreeMap<>();
        Map<String, Integer> cashMap = new TreeMap<>();
        Map<String, Integer> creditCardMap = new TreeMap<>();
        Iterable<LiveMesEntity> liveMesEntities = liveMesRepository.findAll();

        for (LiveMesEntity liveMesEntity : liveMesEntities) {
            String liveDate = Helper.timeToDateString(liveMesEntity.getInTime());

            if (! memberCardMap.containsKey(liveDate)) {

                memberCardMap.put(liveDate, 0);
                cashMap.put(liveDate, 0);
                creditCardMap.put(liveDate, 0);
            }


            switch (liveMesEntity.getPayMethod()) {
                case SystemDefault.PAY_METHOD_MEMBER_CARD: memberCardMap.put(liveDate, memberCardMap.get(liveDate) + 1);break;
                case SystemDefault.PAY_METHOD_CASH: cashMap.put(liveDate, cashMap.get(liveDate) + 1);break;
                case SystemDefault.PAY_METHOD_CREDIT_CARD: creditCardMap.put(liveDate, creditCardMap.get(liveDate) + 1); break;
            }
        }

        for (String eachDate : memberCardMap.keySet()) {
            date.add(eachDate);
            memberCardList.add(memberCardMap.get(eachDate));
            cashList.add(cashMap.get(eachDate));
            creditCardList.add(creditCardMap.get(eachDate));
        }



        result.put("date", date);
        result.put("memberCardList" , memberCardList);
        result.put("cashList", cashList);
        result.put("creditCardList" , creditCardList);


        result.put(SystemDefault.HTTP_RESULT, true);
        return result;
    }
}
