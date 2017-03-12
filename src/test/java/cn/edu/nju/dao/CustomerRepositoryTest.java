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

import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@Commit
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private AccountRepository repository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    HotelRepository hotelRepository;

//    @Test
//    public void testExample() throws Exception {
//
//
//
//        for (int i = 0; i < 100; i++) {
//
//            MemberEntity entity = new MemberEntity();
//            entity.setId(repository.findByMail("czqofnju" + i + "@qq.com").getId());
//            entity.setName("Member " + i);
//            entity.setStatus(0);
//            entity.setPoints(0);
//            memberRepository.save(entity);
////            this.entityManager.persist(entity);
//        }
//
//
////        this.entityManager.persist(entity);
//
////        repository.justForTest("Let us test");
//
////        System.out.println(repository.findByMail("sdfsdaf@sss.com").getId());;
//
//    }


    @Test
    public void fromAccountToHotel() throws Exception {
        List<AccountEntity> accountEntities = repository.findByType(1);

        for (AccountEntity accountEntity : accountEntities) {
            HotelEntity hotelEntity = new HotelEntity();
            hotelEntity.setId(accountEntity.getId());
            hotelRepository.save(hotelEntity);


        }





    }

    @Test
    public void testAddHotelProperties() throws Exception {

        Iterable<HotelEntity> hotelEntities = hotelRepository.findAll();


        int index = 1;


        for (HotelEntity hotelEntity : hotelEntities) {


            switch (index) {
                case 0:
                    hotelEntity.setName("Yasuragi Ioujima Hotel");
                    hotelEntity.setDescription("Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night's sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.");
                    hotelEntity.setAddress("1-3277-7 Iojimamachi ,Nagasaki,Japan");
                    hotelEntity.setPicUrl("/img/hotel/hotel1.jpeg");
                    break;
                case 1:
                    hotelEntity.setName("Shibuya Excel Hotel Tokyu Tokyo");
                    hotelEntity.setDescription("Shinagawa is the south entrance to Tokyo. The Shinagawa Prince Hotel, which is in front of Shinagawa Station, has good access to Narita Airport, Haneda Airport, Big Site, and the Tokyo Forum, as well as movie theaters, bowling, the Epson Shinagawa Aqua Stadium, tennis, golf, swimming pools and other entertainment facilities. From business to sightseeing, this is an entertainment hotel that guests can enjoy in many ways.");
                    hotelEntity.setAddress("10-30 Takanawa 4-chome, Minato-ku ,Shinagawa,Tokyo,Japan");
                    hotelEntity.setPicUrl("/img/hotel/hotel2.jpeg");
                    break;
                case 2:
                    hotelEntity.setName("The Peninsula Tokyo");
                    hotelEntity.setDescription("In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.");
                    hotelEntity.setAddress("2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan");
                    hotelEntity.setPicUrl("/img/hotel/hotel3.jpeg");
                    break;
                case 3:
                    hotelEntity.setName("Wynn Palace");
                    hotelEntity.setDescription("Wynn Palace resets the world’s expectations for luxury. With an entrance that boasts an 8-acre lake, 25-story dancing fountains, Golden Dragons, and glass cable cars around the water’s edge, the ride over this stunning scene transports you to another world. ");
                    hotelEntity.setAddress("Avenida Da Nave Desportiva,Cotai，Macau ,Taipa,Macau,China");
                    hotelEntity.setPicUrl("/img/hotel/hotel4.jpeg");
                    break;

                case 4:
                    hotelEntity.setName("Studio City Hotel");
                    hotelEntity.setDescription("he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ");
                    hotelEntity.setAddress("Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China");
                    hotelEntity.setPicUrl("/img/hotel/hotel5.jpeg");
                    break;
                case 5:
                    hotelEntity.setName("Keio Plaza Hotel Tokyo");
                    hotelEntity.setDescription("In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.");
                    hotelEntity.setAddress("2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan");
                    hotelEntity.setPicUrl("/img/hotel/hotel6.jpeg");
                    break;
            }


            hotelEntity.setStatus(1);
            index++;
            index = index %6;
        }



//        hotelEntities.forEach(hotelEntity -> {
//
//            int num = 4;
//
//            switch (num) {
//                case 4:
//                    hotelEntity.setName("Wynn Palace");
//                    hotelEntity.setDescription("Wynn Palace resets the world’s expectations for luxury. With an entrance that boasts an 8-acre lake, 25-story dancing fountains, Golden Dragons, and glass cable cars around the water’s edge, the ride over this stunning scene transports you to another world. ");
//                    hotelEntity.setAddress("Avenida Da Nave Desportiva,Cotai，Macau ,Taipa,Macau,China");
//                    hotelEntity.setPicUrl("/img/hotel/hotel4.jpeg");
//                    num = 5;
//                case 5:
//                    hotelEntity.setName("Studio City Hotel");
//                    hotelEntity.setDescription("he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ");
//                    hotelEntity.setAddress("Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China");
//                    hotelEntity.setPicUrl("/img/hotel/hotel5.jpeg");
//                case 6:
//                    hotelEntity.setName("Keio Plaza Hotel Tokyo");
//                    hotelEntity.setDescription("In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.");
//                    hotelEntity.setAddress("2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan");
//                    hotelEntity.setPicUrl("/img/hotel/hotel5.jpeg");
//            }
//
//
//        });

    }

//    @Test
//    public void addHotel() throws Exception {
//
//
//
//        for (int i = 0; i < 100; i++) {
//            AccountEntity entity = new AccountEntity();
//            HotelEntity hotelEntity = new HotelEntity();
//            entity.setPassword("123456");
//            entity.setMail("czqofnju" + i + "@hotel.com");
//            entity.setType(1);
//            entity = repository.save(entity);
//            hotelEntity.setId(repository.findByMail("czqofnju" + i + "@hotel.com").getId());
//            hotelRepository.save(hotelEntity);
//
////            entity.setId(repository.findByMail("czqofnju" + i + "@qq.com").getId());
////            entity.setName("Member " + i);
////            entity.setStatus(0);
////            entity.setPoints(0);
////            memberRepository.save(entity);
////            this.entityManager.persist(entity);
//        }
//
//
////        this.entityManager.persist(entity);
//
////        repository.justForTest("Let us test");
//
////        System.out.println(repository.findByMail("sdfsdaf@sss.com").getId());;
//
//    }
}