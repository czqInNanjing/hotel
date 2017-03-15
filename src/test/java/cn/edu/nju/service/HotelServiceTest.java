package cn.edu.nju.service;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.MemberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Qiang
 * @since 07/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Commit
public class HotelServiceTest {


    @Autowired
    HotelService hotelService;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoomsRepository roomsRepository;

    @Autowired
    LiveMesRepository liveMesRepository;
    @Autowired
    PayRecordRepository payRecordRepository;
    @Test
    public void name() throws Exception {
        Random random = new Random();
        liveMesRepository.findAll().forEach(liveMesEntity -> {

            liveMesEntity.setInTime(new Timestamp(System.currentTimeMillis() + random.nextInt(7*3600*24*1000)) );
            liveMesRepository.save(liveMesEntity);
        });

        payRecordRepository.findAll().forEach(payRecordEntity -> {
            payRecordEntity.setTime(new Timestamp(System.currentTimeMillis() + random.nextInt(7*3600*24*1000) ));
            payRecordRepository.save(payRecordEntity);
        });

    }

    @Test
    public void addOutRecords() throws Exception {




    }


    @Test
    public void addInRecords() throws Exception {
        List<HotelEntity> availableHotel = hotelRepository.findByStatus(1);
        List<MemberEntity> memberEntities = memberRepository.findByStatus(1);
        Random random = new Random();
        Random random2 = new Random();
        for (int i = 0; i < availableHotel.size(); i++) {
            int hotelId = availableHotel.get(i).getId();
            for (int j = 0; j < 10; j++) {
                int roomId = roomsRepository.findByHotelIdAndStatus(hotelId, 0).get(0).getId();
                int personNum = random.nextInt(2) + 1;
                String personMes = "Not any description yet.";
                int isMember = random2.nextInt(2) ;
                int payMethod;
                int memberId = 0;
                if (isMember == 1) {
                    memberId = memberEntities.get(random.nextInt(memberEntities.size())).getId();
                    payMethod = random.nextInt(3);
                    if (payMethod == 0) {
                        memberEntities.get(random.nextInt(memberEntities.size()));
                    }


                } else {
                    payMethod = random.nextInt(2) + 1;
                }

                hotelService.addInRecords(personNum, personMes, isMember, payMethod, memberId, roomId, hotelId, false);
            }

        }


    }


    @Test
    public void re() throws Exception {
        liveMesRepository.findAll().forEach( liveMesEntity -> {
            if (liveMesEntity.getPersonNum() == 0) {
                liveMesEntity.setPersonNum(2);
                liveMesRepository.save(liveMesEntity);
            }


        });
    }

    @Test
    public void testEdit() throws Exception {


        List<HotelEntity> hotelEntities = hotelRepository.findByStatus(1);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {

            if (random.nextInt(3) != 1) {
                hotelService.saveModifyApplication("I want to change to a new name", "new address", "new description",hotelEntities.get(i).getId(), "/img/hotel/hotel2.jpeg" );

//                hotelRepository.save()
            }


        }
    }
}