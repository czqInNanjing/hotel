package cn.edu.nju.dao;

import cn.edu.nju.entity.PayRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 06/03/2017
 */
public interface SimplePayRecordRepository extends JpaRepository<PayRecordEntity, Integer> {
    List< PayRecordEntity> findByLiveId(int id);
}
