package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.MemberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Commit
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private AccountRepository repository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    HotelRepository hotelRepository;

    @Test
    public void testExample() throws Exception {



        for (int i = 0; i < 100; i++) {

            MemberEntity entity = new MemberEntity();
            entity.setId(repository.findByMail("czqofnju" + i + "@qq.com").getId());
            entity.setName("Member " + i);
            entity.setStatus(0);
            entity.setPoints(0);
            memberRepository.save(entity);
//            this.entityManager.persist(entity);
        }


//        this.entityManager.persist(entity);

//        repository.justForTest("Let us test");

//        System.out.println(repository.findByMail("sdfsdaf@sss.com").getId());;

    }

    @Test
    public void addHotel() throws Exception {



        for (int i = 0; i < 100; i++) {
            AccountEntity entity = new AccountEntity();
            HotelEntity hotelEntity = new HotelEntity();
            entity.setPassword("123456");
            entity.setMail("czqofnju" + i + "@hotel.com");
            entity.setType(1);
            entity = repository.save(entity);
            hotelEntity.setId(repository.findByMail("czqofnju" + i + "@hotel.com").getId());
            hotelRepository.save(hotelEntity);

//            entity.setId(repository.findByMail("czqofnju" + i + "@qq.com").getId());
//            entity.setName("Member " + i);
//            entity.setStatus(0);
//            entity.setPoints(0);
//            memberRepository.save(entity);
//            this.entityManager.persist(entity);
        }


//        this.entityManager.persist(entity);

//        repository.justForTest("Let us test");

//        System.out.println(repository.findByMail("sdfsdaf@sss.com").getId());;

    }
}