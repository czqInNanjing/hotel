package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private AccountRepository repository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testExample() throws Exception {
        AccountEntity entity = new AccountEntity();
//        entity.setId(1);
        entity.setMail("sdfsdaf@sss.com");
        entity.setPassword("sdfdsf");

        this.entityManager.persist(entity);
        this.entityManager.persist(entity);
//        repository.justForTest("Let us test");

        System.out.println(repository.findByMail("sdfsdaf@sss.com").getId());;

    }


}