package cn.edu.nju.dao;

import cn.edu.nju.entity.LiveMesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface LiveMesRepository extends CrudRepository<LiveMesEntity, Integer>{
    List<LiveMesEntity> findByHotelId(int hotelId);
}
