package cn.edu.nju.dao;

import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface OpenApplicationRepository extends PagingAndSortingRepository<OpenApplicationEntity, Integer> {

    boolean existsByHotelId(int hotelID);

    List<OpenApplicationEntity> findByStatus(int status);

    Page<OpenApplicationEntity> findByStatus(int status, Pageable page);
    List<OpenApplicationEntity> findByHotelId(int hotelID);

    boolean existsByHotelIdAndStatus(int hotelId , int status);
}
