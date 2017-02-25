package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 25/02/2017
 */
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

}
