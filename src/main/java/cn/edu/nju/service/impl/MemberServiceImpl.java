package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.MemberEntity;
import cn.edu.nju.entity.PayRecordEntity;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.vo.MemberInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, RechargeRepository rechargeRepository, PointConvertRepository pointConvertRepository, PayRecordRepository payRecordRepository, AccountRepository accountRepository) {
        this.memberRepository = memberRepository;
        this.rechargeRepository = rechargeRepository;
        this.pointConvertRepository = pointConvertRepository;
        this.payRecordRepository = payRecordRepository;
        this.accountRepository = accountRepository;
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
    public boolean recharge(int id, int amount) {
        MemberEntity entity = memberRepository.findOne(id);
        if (entity != null) {
            entity.setDeposit(entity.getDeposit() + amount);
            memberRepository.save(entity);
            return true;
        }
        return false;
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
                memberRepository.save(entity);
                result.put("result", true);
                result.put("reason", "You have successfully converted " + points + " points");
            } else {
                result.put("result", false);
                result.put("reason", "Points Not enough");
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
}
