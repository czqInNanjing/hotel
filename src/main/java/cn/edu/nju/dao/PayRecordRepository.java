package cn.edu.nju.dao;

import cn.edu.nju.dao.custom.CustomPayRecordRepository;
import cn.edu.nju.entity.PayRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface PayRecordRepository extends JpaRepository<PayRecordEntity, Integer>, CustomPayRecordRepository {


    List<PayRecordEntity> findByLiveId(int id);
}
