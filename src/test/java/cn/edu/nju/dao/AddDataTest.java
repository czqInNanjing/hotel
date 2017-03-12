package cn.edu.nju.dao;

import cn.edu.nju.entity.AccountEntity;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.MemberEntity;
import cn.edu.nju.entity.RoomsEntity;
import cn.edu.nju.util.SystemDefault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author Qiang
 * @since 07/03/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@Commit
public class AddDataTest {


    @Autowired
    private AccountRepository repository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomsRepository roomsRepository;


    @Test
    public void addMemberData() throws Exception {
        List<AccountEntity> accountEntities = repository.findByType(0);
        Random random = new Random();
        for (AccountEntity accountEntity : accountEntities) {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setId(accountEntity.getId());
            memberEntity.setName("Member" + random.nextInt(2000));
            memberEntity.setStatus(1);
            memberEntity.setRemainDays(random.nextInt(365));
            memberEntity.setCreditCard(String.valueOf(Math.abs(random.nextLong())));
            memberEntity.setRegistDate(new Timestamp(System.currentTimeMillis() - random.nextInt(30)*3600*24*1000));
            memberEntity.setDeposit(random.nextInt(3000));
            memberRepository.save(memberEntity);



        }

    }

    @Test
    public void name() throws Exception {
        Iterable<RoomsEntity> roomsEntityIterator = roomsRepository.findAll();
        Random random = new Random();
        for (RoomsEntity roomsEntity : roomsEntityIterator) {
            roomsEntity.setType(random.nextInt(2) + 1);
        }
        roomsRepository.save(roomsEntityIterator);
    }

    @Test
    public void addRooms() throws Exception {
        Iterable<HotelEntity> hotelEntities = hotelRepository.findAll();
        List<RoomsEntity> roomsEntities = new ArrayList<>(40);
        for (HotelEntity hotelEntity : hotelEntities){
            Random random = new Random();
            Random random2 = new Random();
            Random random3 = new Random();
            Random random4 = new Random();
            Random random5 = new Random();
            Random random6 = new Random();
            for (int i = 0; i < 40; i++) {
                RoomsEntity roomsEntity = new RoomsEntity();
                roomsEntity.setHotelId(hotelEntity.getId());
                roomsEntity.setPicUrl("/img/room/room" + (i%6 + 1)  +".jpg");

                roomsEntity.setArea(random.nextInt(40) + 30);
                roomsEntity.setName("room" + i);
                roomsEntity.setBreakfast(random2.nextInt(2));
                roomsEntity.setWifi(random3.nextInt(2));
                roomsEntity.setType(random4.nextInt(2) + 1);
                roomsEntity.setPrice(random5.nextInt(100) + 50);
//                roomsEntity.setAvailableTime();
                roomsEntities.add(roomsEntity);
                roomsEntity.setAvailableTime(new Timestamp(System.currentTimeMillis() + random6.nextInt(10)*3600*24*1000));

            }
            roomsRepository.save(roomsEntities);
            roomsEntities.clear();

        }



    }
}
