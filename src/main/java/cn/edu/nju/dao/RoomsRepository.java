package cn.edu.nju.dao;

import cn.edu.nju.entity.RoomsEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface RoomsRepository extends CrudRepository<RoomsEntity, Integer> {
}
