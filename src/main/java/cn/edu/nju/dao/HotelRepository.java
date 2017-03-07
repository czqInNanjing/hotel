package cn.edu.nju.dao;

import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.RoomsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 25/02/2017
 */
public interface HotelRepository extends PagingAndSortingRepository<HotelEntity, Integer> {


    List<HotelEntity> findByStatus(int status);
}
