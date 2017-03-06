package cn.edu.nju.dao.custom.impl;

import cn.edu.nju.dao.LiveMesRepository;
import cn.edu.nju.dao.PayRecordRepository;
import cn.edu.nju.dao.SimplePayRecordRepository;
import cn.edu.nju.dao.custom.CustomPayRecordRepository;
import cn.edu.nju.entity.PayRecordEntity;
import cn.edu.nju.entity.RechargeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiang
 * @since 06/03/2017
 */
@Repository
public class PayRecordRepositoryImpl implements CustomPayRecordRepository {
    // to avoid cycle construction, use another instance of pay record repository
    private final SimplePayRecordRepository payRecordRepository;
    private final LiveMesRepository liveMesRepository;
    @Autowired
    public PayRecordRepositoryImpl(SimplePayRecordRepository payRecordRepository, LiveMesRepository liveMesRepository) {
        this.payRecordRepository = payRecordRepository;
        this.liveMesRepository = liveMesRepository;
    }


    @Override
    public List<PayRecordEntity> findPayRecordByMemberId(int memberId) {
        List<PayRecordEntity> rechargeEntities = new ArrayList<>();

        liveMesRepository.findByMemberId(memberId).forEach(liveMesEntity -> {

            rechargeEntities.addAll(payRecordRepository.findByLiveId(liveMesEntity.getId()));

        });

        return rechargeEntities;
    }
}
