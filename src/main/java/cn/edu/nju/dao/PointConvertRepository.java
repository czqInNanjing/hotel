package cn.edu.nju.dao;

import cn.edu.nju.entity.PointConvertEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 02/03/2017
 */
public interface PointConvertRepository extends CrudRepository<PointConvertEntity, Integer> {
    List<PointConvertEntity> findByMemberId(int id);
}
