package cn.edu.nju.dao;

import cn.edu.nju.entity.LiveMesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface LiveMesRepository extends PagingAndSortingRepository<LiveMesEntity, Integer> {
    List<LiveMesEntity> findByHotelId(int hotelId);
    Page<LiveMesEntity> findByHotelId(int hotelId, Pageable pageable);

    List<LiveMesEntity> findByMemberId(int id);
}
