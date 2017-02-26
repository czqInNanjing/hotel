package cn.edu.nju.dao;

import cn.edu.nju.entity.HotelEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 25/02/2017
 */
public interface HotelRepository extends CrudRepository<HotelEntity, Integer> {
}
