package cn.edu.nju.dao;

import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface ModifyApplicationRepository extends PagingAndSortingRepository<ModifyApplicationEntity, Integer> {

    boolean existsByHotelIdAndStatus(int hotelID, int status);

    Page<ModifyApplicationEntity> findByStatus(int status, Pageable pageRequest);
    List<ModifyApplicationEntity> findByStatus(int status);
}
