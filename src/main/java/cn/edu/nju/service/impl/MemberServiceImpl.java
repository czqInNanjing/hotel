package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.Helper;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Qiang
 * @since 02/03/2017
 */
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final RechargeRepository rechargeRepository;
    private final PointConvertRepository pointConvertRepository;
    private final PayRecordRepository payRecordRepository;
    private final AccountRepository accountRepository;
    private final ReservedRepository reservedRepository;
    private final RoomsRepository roomsRepository;

    private final LiveMesRepository liveMesRepository;
    private final HotelRepository hotelRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, RechargeRepository rechargeRepository, PointConvertRepository pointConvertRepository, PayRecordRepository payRecordRepository, AccountRepository accountRepository, ReservedRepository reservedRepository, RoomsRepository roomsRepository, LiveMesRepository liveMesRepository, HotelRepository hotelRepository) {
        this.memberRepository = memberRepository;
        this.rechargeRepository = rechargeRepository;
        this.pointConvertRepository = pointConvertRepository;
        this.payRecordRepository = payRecordRepository;
        this.accountRepository = accountRepository;
        this.reservedRepository = reservedRepository;
        this.roomsRepository = roomsRepository;

        this.liveMesRepository = liveMesRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public boolean isActivated(int id) {

        MemberEntity entity = memberRepository.findOne(id);
        return entity != null && entity.getStatus() == 1;
    }

    @Override
    public PayRecordEntity pay(int id, int amount) {
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            if (entity.getDeposit() > amount) {
                int after = (entity.getDeposit() - amount)* (100 -entity.getDiscount())/100;
                entity.setDeposit(after);
                entity.setAccumulate(entity.getAccumulate() + amount);
                List<Integer> levelAndAccount = Helper.getLevelAndDiscount(entity.getAccumulate());
                entity.setMemberLevel(levelAndAccount.get(0));
                entity.setDiscount(levelAndAccount.get(1));
//                entity.setPoints(entity.addPoints() + amount);
                memberRepository.save(entity);
                PayRecordEntity payRecordEntity = new PayRecordEntity(amount, after);
                payRecordEntity = payRecordRepository.save(payRecordEntity);
                return payRecordEntity;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> recharge(int id, int amount) {
        Map<String,Object> result = new TreeMap<>();
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            entity.setDeposit(entity.getDeposit() + amount);
            memberRepository.save(entity);
            result.put(SystemDefault.HTTP_RESULT, true);

            // add the recharge record
            RechargeEntity rechargeEntity = new RechargeEntity();
            rechargeEntity.setMemberId(id);
            rechargeEntity.setFormer(entity.getDeposit() - amount);
            rechargeEntity.setAfter(entity.getDeposit());
            rechargeRepository.save(rechargeEntity);


            if (entity.getDeposit() >= 1000 && entity.getStatus() == 0) {
                entity.setStatus(1);
                entity.setRemainDays(365);
                memberRepository.save(entity);
                result.put(SystemDefault.HTTP_REASON, "Your account has been activated.");
            } else {
                result.put(SystemDefault.HTTP_REASON, "You have recharged "+ amount + " dollars.");
            }


            return result;
        }
        result.put(SystemDefault.HTTP_RESULT, true);
        return result;
    }

    @Override
    public void addPoints(int id, int amount) {
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            entity.setPoints(entity.getPoints() + amount);
            memberRepository.save(entity);
        }


    }

    @Override
    public Map<String, Object> convertPoints(int id, int points) {
        Map<String,Object> result = new TreeMap<>();
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            if (points <= entity.getPoints()) {
                entity.setPoints(entity.getPoints() - points);
                entity.setDeposit(entity.getDeposit() + points);
                entity = memberRepository.save(entity);


                // convert point
                PointConvertEntity pointConvertEntity = new PointConvertEntity();
                pointConvertEntity.setAmount(points);
                pointConvertEntity.setPoint(points);
                pointConvertEntity.setAfter(entity.getDeposit());
                pointConvertEntity.setMemberId(id);
                pointConvertRepository.save(pointConvertEntity);



                result.put(SystemDefault.HTTP_RESULT, true);
                result.put(SystemDefault.HTTP_REASON, "You have successfully converted " + points + " points");
            } else {
                result.put(SystemDefault.HTTP_RESULT, false);
                result.put(SystemDefault.HTTP_REASON, "Points Not enough");
            }


        }


        return result;
    }

    @Override
    public MemberInfoVO getMemberProfile(int id) {
        MemberEntity entity = memberRepository.findOne(id);
        MemberInfoVO vo = new MemberInfoVO();
        BeanUtils.copyProperties(entity , vo);
        String mail = accountRepository.findOne(id).getMail();
        vo.setMail(mail);

        return vo;
    }

    @Override
    public Map<String, Object> reserve(int id, int roomId) {
        Map<String, Object> result = new TreeMap<>();
        RoomsEntity entity = roomsRepository.findOne(roomId);

        if (entity != null) {
            if (entity.getStatus() == 0) {
                entity.setStatus(SystemDefault.ROOM_RESERVED);
                roomsRepository.save(entity);
            } else {
                result.put(SystemDefault.HTTP_RESULT, false);
                result.put(SystemDefault.HTTP_REASON, "Room has been occupied");
                return result;
            }

            ReservedEntity reservedEntity = new ReservedEntity();
            reservedEntity.setTime(new Timestamp(System.currentTimeMillis()));
            reservedEntity.setMemberId(id);
            reservedEntity.setRoomId(roomId);
            reservedRepository.save(reservedEntity);

            result.put(SystemDefault.HTTP_RESULT, true);
//            result.put(SystemDefault.HTTP_REASON, "Room has been occupied");
            return result;
        }






        return null;
    }

    @Override
    public Map<String, Object> edit(int id, String name, String mail, String creditCard) {
        Map<String,Object> result = new TreeMap<>();
        AccountEntity accountEntity = accountRepository.findOne(id);

        accountEntity.setMail(mail);
        if (accountRepository.findByMail(mail) != null) {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Mail has been occupied");
            return result;
        }
        accountRepository.save(accountEntity);
        MemberEntity memberEntity = memberRepository.findOne(id);
        memberEntity.setName(name);
        memberEntity.setCreditCard(creditCard);
        memberRepository.save(memberEntity);
        result.put(SystemDefault.HTTP_RESULT, true);
        return result;
    }

    @Override
    public Map<String, Object> deleteAccount(int id, String password) {
        Map<String,Object> result = new TreeMap<>();
        //check password
        if (accountRepository.existsByIdAndPassword(id, password)) {
            deleteAccount(id);
            result.put(SystemDefault.HTTP_RESULT, true);
            return result;
        }


        result.put(SystemDefault.HTTP_RESULT, false);
        result.put(SystemDefault.HTTP_REASON, "password is error!");

        return result;
    }

    @Override
    public void deleteAccount(int id) {
        reservedRepository.deleteByMemberId(id);
        memberRepository.delete(id);
        accountRepository.delete(id);
    }

    @Override
    public String statistics(Model model, int id) {
        List<ReservedEntity> reservedEntities = reservedRepository.findByMemberId(id);
        List<LiveMesEntity> liveMesEntities = liveMesRepository.findByMemberId(id);
        List<RechargeEntity> rechargeEntities = rechargeRepository.findByMemberId(id);
        List<PayRecordEntity> payRecordEntities = payRecordRepository.findPayRecordByMemberId(id);
        List<PointConvertEntity> pointConvertEntities = pointConvertRepository.findByMemberId(id);


        model.addAttribute("statistics", buildMemberStatisticsVO(reservedEntities, liveMesEntities, rechargeEntities, payRecordEntities, pointConvertEntities));
        return "member/statistics";
    }

    @Override
    public Map<String, Object> cancelReservation(int id, int recordToCancel) {
        Map<String, Object> result = new TreeMap<>();
        ReservedEntity entity = reservedRepository.findOne(recordToCancel);
        if (entity != null) {
            RoomsEntity roomsEntity = roomsRepository.findOne(entity.getRoomId());
            roomsEntity.setStatus(SystemDefault.ROOM_ACTIVE);
            roomsRepository.save(roomsEntity);
            reservedRepository.delete(recordToCancel);
            result.put(SystemDefault.HTTP_RESULT, true);
            return result;
        }
        result.put(SystemDefault.HTTP_RESULT, false);
        result.put(SystemDefault.HTTP_REASON, "Reservation Record Not Found!");
        return result;

    }

    @Override
    public List<Integer> getMemberStatus(int id) {
        int numOfReserved = reservedRepository.findByMemberId(id).size();
        int numOfLive = liveMesRepository.findByMemberId(id).size();

        int numOfRecharge = rechargeRepository.findByMemberId(id).size();

        List<Integer> result = new ArrayList<>(3);
        result.add(numOfReserved);
        result.add(numOfLive);
        result.add(numOfRecharge);


        return result;
    }


    private MemberStatisticsVO buildMemberStatisticsVO(List<ReservedEntity> reservedEntities, List<LiveMesEntity> liveMesEntities, List<RechargeEntity> rechargeEntities, List<PayRecordEntity> payRecordEntities, List<PointConvertEntity> pointConvertEntities) {

        MemberStatisticsVO vo = new MemberStatisticsVO();

        List<LiveMesVO> liveMesVOS = new ArrayList<>(liveMesEntities.size());

        liveMesEntities.forEach(entity ->  {
            LiveMesVO liveMesVO = new LiveMesVO();
            BeanUtils.copyProperties(entity, liveMesVO);
            liveMesVO.setHotelName(hotelRepository.findOne(entity.getHotelId()).getName());
            liveMesVO.setRoomName(roomsRepository.findOne(entity.getRoomId()).getName());
            liveMesVO.setTotal(roomsRepository.findOne(entity.getRoomId()).getPrice());
            liveMesVOS.add(liveMesVO);
        });

        List<ReservedVO> reservedVOS = new ArrayList<>(reservedEntities.size());

        reservedEntities.forEach(entity ->  {
            ReservedVO reservedVO = new ReservedVO();
            BeanUtils.copyProperties(entity, reservedVO);

            RoomsEntity roomsEntity= roomsRepository.findOne(entity.getRoomId());
            reservedVO.setRoomName(roomsEntity.getName());
            reservedVO.setHotelName(hotelRepository.findOne(roomsEntity.getHotelId()).getName());
            reservedVOS.add(reservedVO);
        });


        List<ConsumptionVO> consumptionVOS = new ArrayList<>();

        rechargeEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setAmount(entity.getAfter() - entity.getFormer());
            consumptionVO.setType(SystemDefault.RECHARGE_ENTITY);
            consumptionVOS.add(consumptionVO);
        });
        pointConvertEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setType(SystemDefault.POINT_CONVERT_ENTITY);
            consumptionVOS.add(consumptionVO);
        });
        payRecordEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setAmount(entity.getBill());
            consumptionVO.setType(SystemDefault.PAY_RECORD_ENTITY);
            consumptionVOS.add(consumptionVO);
        });




        vo.setLiveMesVOS(liveMesVOS);
        vo.setReservedVOS(reservedVOS);
        vo.setConsumptionVOS(consumptionVOS);



        return vo;
    }


}
