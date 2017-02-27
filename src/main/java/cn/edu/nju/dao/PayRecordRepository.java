package cn.edu.nju.dao;

import cn.edu.nju.entity.PayRecordEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface PayRecordRepository extends CrudRepository<PayRecordEntity, Integer> {
}
