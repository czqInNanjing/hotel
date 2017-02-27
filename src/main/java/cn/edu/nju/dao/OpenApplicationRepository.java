package cn.edu.nju.dao;

import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface OpenApplicationRepository extends CrudRepository<OpenApplicationEntity, Integer> {

    List<OpenApplicationEntity> findByStatus(Byte status);


    List<OpenApplicationEntity> findByHotelId(int hotelID);
}
