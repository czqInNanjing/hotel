package cn.edu.nju.dao;

import cn.edu.nju.entity.ReservedEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface ReservedRepository extends CrudRepository<ReservedEntity, Integer> {

    void deleteByMemberId(int memberId);


}
