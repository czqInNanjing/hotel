package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.AccountService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.ConsumptionVO;
import cn.edu.nju.vo.MemberInfoVO;
import cn.edu.nju.vo.MemberStatisticsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    private final AccountService accountService;
    private final LiveMesRepository liveMesRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, RechargeRepository rechargeRepository, PointConvertRepository pointConvertRepository, PayRecordRepository payRecordRepository, AccountRepository accountRepository, ReservedRepository reservedRepository, RoomsRepository roomsRepository, AccountService accountService, LiveMesRepository liveMesRepository) {
        this.memberRepository = memberRepository;
        this.rechargeRepository = rechargeRepository;
        this.pointConvertRepository = pointConvertRepository;
        this.payRecordRepository = payRecordRepository;
        this.accountRepository = accountRepository;
        this.reservedRepository = reservedRepository;
        this.roomsRepository = roomsRepository;
        this.accountService = accountService;
        this.liveMesRepository = liveMesRepository;
    }

    @Override
    public boolean isActivated(int id) {

        MemberEntity entity = memberRepository.findOne(id);
        return entity != null && entity.getStatus() == 1;
    }

    @Override
    public boolean pay(int id, int amount) {
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            if (entity.getDeposit() > amount) {
                int after = entity.getDeposit() - amount;
                entity.setDeposit(after);
//                entity.setPoints(entity.addPoints() + amount);
                memberRepository.save(entity);
                PayRecordEntity payRecordEntity = new PayRecordEntity(amount, after);
                payRecordRepository.save(payRecordEntity);
                return true;
            }
        }
        return false;
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
        return "/member/statistics";
    }





    private static MemberStatisticsVO buildMemberStatisticsVO(List<ReservedEntity> reservedEntities, List<LiveMesEntity> liveMesEntities, List<RechargeEntity> rechargeEntities, List<PayRecordEntity> payRecordEntities, List<PointConvertEntity> pointConvertEntities) {

        MemberStatisticsVO vo = new MemberStatisticsVO();
        vo.setLiveMesEntities(liveMesEntities);
        vo.setReservedEntities(reservedEntities);

        List<ConsumptionVO> vos = new ArrayList<>();

        rechargeEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setAmount(entity.getAfter() - entity.getFormer());
            consumptionVO.setType(SystemDefault.RECHARGE_ENTITY);
            vos.add(consumptionVO);
        });
        pointConvertEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setType(SystemDefault.POINT_CONVERT_ENTITY);
            vos.add(consumptionVO);
        });
        payRecordEntities.forEach(entity -> {
            ConsumptionVO consumptionVO = new ConsumptionVO();
            BeanUtils.copyProperties(entity, consumptionVO);
            consumptionVO.setAmount(entity.getBill());
            consumptionVO.setType(SystemDefault.PAY_RECORD_ENTITY);
            vos.add(consumptionVO);
        });

        vo.setConsumptionVOS(vos);



        return vo;
    }


}
