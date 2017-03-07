package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Qiang
 * @since 25/02/2017
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

    AccountEntity findByMail(String mail);

    AccountEntity findByMailAndPassword(String mail, String password);

    boolean existsByIdAndPassword(int id, String password);

    List<AccountEntity> findByType(int type);
}
