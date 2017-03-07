package cn.edu.nju.dao;

import cn.edu.nju.entity.ReservedEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Qiang
 * @since 07/03/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ReservedRepositoryTest {
    @Autowired
    ReservedRepository reservedRepository;


    @Test
    public void findByHotelId() throws Exception {

        List<ReservedEntity> reservedEntities = reservedRepository.findByHotelId(5);





    }

}