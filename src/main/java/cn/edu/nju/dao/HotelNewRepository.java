package cn.edu.nju.dao;

import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.HotelNewEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public interface HotelNewRepository extends CrudRepository<HotelNewEntity, Integer> {

    boolean exists(int id);

    HotelNewEntity findByOldHotel(int id);
}
