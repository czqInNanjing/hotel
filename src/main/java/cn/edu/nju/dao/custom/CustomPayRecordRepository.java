package cn.edu.nju.dao.custom;

import cn.edu.nju.entity.PayRecordEntity;
import cn.edu.nju.entity.RechargeEntity;

import java.util.List;

/**
 * @author Qiang
 * @since 06/03/2017
 */
public interface CustomPayRecordRepository {
    List<PayRecordEntity> findPayRecordByMemberId(int memberId);
}
