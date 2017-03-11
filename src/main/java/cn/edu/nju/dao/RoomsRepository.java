package cn.edu.nju.dao;

import cn.edu.nju.entity.RoomsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface RoomsRepository extends JpaRepository<RoomsEntity, Integer> {

    List<RoomsEntity> findByHotelId(int hotelId);
    Page<RoomsEntity> findByHotelId(int hotelId, Pageable pageRequest);
    Page<RoomsEntity> findByHotelIdAndStatus(int hotelId, int status, Pageable pageRequest);
    List<RoomsEntity> findByHotelIdAndStatus(int hotelId, int status);
    List<RoomsEntity> findByStatus(int status);
}
