package cn.edu.nju.dao;

import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface OpenApplicationRepository extends CrudRepository<OpenApplicationEntity, Integer> {

    boolean existsByHotelId(int hotelID);

    List<OpenApplicationEntity> findByStatus(int status);


    List<OpenApplicationEntity> findByHotelId(int hotelID);

    boolean existsByHotelIdAndStatus(int hotelId , int status);
}
