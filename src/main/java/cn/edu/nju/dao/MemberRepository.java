package cn.edu.nju.dao;

import cn.edu.nju.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 26/02/2017
 */
public interface MemberRepository extends CrudRepository<MemberEntity, Integer> {


    List<MemberEntity> findByStatus(int status);
}
