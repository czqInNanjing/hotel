package cn.edu.nju.service;

import cn.edu.nju.dao.MemberRepository;
import cn.edu.nju.dao.RoomsRepository;
import cn.edu.nju.entity.MemberEntity;
import cn.edu.nju.entity.RoomsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Qiang
 * @since 07/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Commit
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoomsRepository roomsRepository;

    @Test
    public void recharge() throws Exception {

        Iterable<MemberEntity> memberEntities = memberRepository.findAll();
        Random random = new Random();

        for (MemberEntity memberEntity : memberEntities) {

            int result = random.nextInt(10);
            if (result < 3) {
                memberService.recharge(memberEntity.getId() , random.nextInt(300 + 1));
            }




        }
    }



    @Test
    public void convertPoints() throws Exception {
         // TODO wait until user has points
    }



    @Test
    public void reserve() throws Exception {
        Iterable<MemberEntity> memberEntities = memberRepository.findAll();
        Random random = new Random();
        List<RoomsEntity> roomsEntities = roomsRepository.findByStatus(0);
        int index = 0;
        for (MemberEntity memberEntity : memberEntities) {

            int result = random.nextInt(10);
            if (result < 5) {
                memberService.reserve(memberEntity.getId(), roomsEntities.get(index).getId());
            }
            index += 20;



        }
    }



}