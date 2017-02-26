package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Qiang
 * @since 25/02/2017
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

    AccountEntity findByMail(String mail);

    AccountEntity findByMailAndPassword(String mail, String password);
}
