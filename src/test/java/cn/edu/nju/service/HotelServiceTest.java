package cn.edu.nju.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Qiang
 * @since 07/03/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class HotelServiceTest {
    @Test
    public void getHotelReservedStatus() throws Exception {

    }

    @Test
    public void getHotelLiveStatus() throws Exception {

    }

    @Test
    public void getHotelConsumptionStatus() throws Exception {

    }

}