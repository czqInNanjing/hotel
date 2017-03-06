package cn.edu.nju.dao;

import cn.edu.nju.entity.RechargeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface RechargeRepository extends CrudRepository<RechargeEntity, Integer> {
    List<RechargeEntity> findByMemberId(int id);
}
