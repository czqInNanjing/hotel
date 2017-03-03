package cn.edu.nju.dao;

import cn.edu.nju.entity.SettlementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 03/03/2017
 */
public interface SettlementRepository extends PagingAndSortingRepository<SettlementEntity, Integer> {


    SettlementEntity findByHotelIdAndStatus(int hotelId, int status);

    Page<SettlementEntity> findByStatus(int status, Pageable pageRequest);

    List<SettlementEntity> findByStatus(int status);
}
