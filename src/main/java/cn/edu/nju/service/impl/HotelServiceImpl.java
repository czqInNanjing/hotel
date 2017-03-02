package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Qiang
 * @since 01/03/2017
 */
@Service
public class HotelServiceImpl implements HotelService {

    private final ModifyApplicationRepository modifyApplicationRepository;
    private final OpenApplicationRepository openApplicationRepository;
    private final HotelNewRepository hotelNewRepository;
    private final HotelRepository hotelRepository;
    private final RoomsRepository roomsRepository;
    private final LiveMesRepository liveMesRepository;
    private final MemberService memberService;
    @Autowired
    public HotelServiceImpl(ModifyApplicationRepository modifyApplicationRepository, OpenApplicationRepository openApplicationRepository, HotelNewRepository hotelNewRepository, HotelRepository hotelRepository, RoomsRepository roomsRepository, LiveMesRepository liveMesRepository, MemberService memberService) {
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.openApplicationRepository = openApplicationRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
        this.liveMesRepository = liveMesRepository;
        this.memberService = memberService;
    }

    @Override
    public HotelEntity getHotelByHotelId(int hotelId) {
        return hotelRepository.findOne(hotelId);
    }

    @Override
    public List<RoomsEntity> findRoomsByHotelId(int hotelId) {
        return roomsRepository.findByHotelId(hotelId);
    }

    @Override
    public List<RoomsEntity> findRoomsByHotelIdAndPage(int hotelId, int page) {
        //TODO
        return null;
    }

    @Override
    public List<LiveMesEntity> findLiveMesByHotelId(int hotelId) {
        return liveMesRepository.findByHotelId(hotelId);
    }

    @Override
    public List<LiveMesEntity> findLiveMesByHotelIdAndPage(int hotelId, int page) {
        return null;
    }

    @Override
    public boolean isApplyingForOpen(int hotelId) {

        return openApplicationRepository.existsByHotelId(hotelId);
    }

    @Override
    public boolean isApplyingForEditing(int hotelId) {

        return modifyApplicationRepository.existsByHotelId(hotelId);
    }

    @Override
    public void saveOpenApplication(String reason, int id) {
        OpenApplicationEntity openApplication = new OpenApplicationEntity();
        openApplication.setReason(reason);
        openApplication.setHotelId(id);
        openApplicationRepository.save(openApplication);
    }

    @Override
    public void saveModifyApplication(String name, String address, String description, int hotelId) {
        HotelNewEntity newEntity = new HotelNewEntity(name,address,description,hotelId);
        newEntity = hotelNewRepository.save(newEntity);
        ModifyApplicationEntity modifyApplicationEntity = new ModifyApplicationEntity(hotelId, newEntity.getId());
        modifyApplicationRepository.save(modifyApplicationEntity);
    }

    @Override
    public List<RoomsEntity> addRooms(String time, boolean wifi, String picUrl, int area, int type, int price, int number, int id) {

        List<RoomsEntity> roomsEntities = new ArrayList<>(number);
        for (int i = 0 ; i < number ; i ++) {
            roomsEntities.add(new RoomsEntity(id,Helper.getTimeStamp(time), (byte) (wifi ? 1 : 0),picUrl,type, price));
        }
        roomsRepository.save(roomsEntities);
//        RoomsEntity roomsEntity = new RoomsEntity(id,Helper.getTimeStamp(time), (byte) (wifi ? 1 : 0),picUrl,type, price);
        roomsEntities.clear();
        roomsEntities.addAll(roomsRepository.findByHotelId(id));
        return roomsEntities;

    }

    @Override
    public List<LiveMesEntity> addOutRecords(int recordId) {
        LiveMesEntity entity = liveMesRepository.findOne(recordId);
        if (entity != null) {
            entity.setOutTime(new Timestamp(System.currentTimeMillis()));
            entity.setStatus(1);
            liveMesRepository.save(entity);
            RoomsEntity roomsEntity = roomsRepository.findOne(entity.getRoomId());
            roomsEntity.setStatus(3);
            roomsRepository.save(roomsEntity);

        }
        return new ArrayList<>();
    }

    @Override
    public synchronized Map<String, Object> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, int hotelId) {
        Map<String, Object> result = new TreeMap<>();
        RoomsEntity roomsEntity = roomsRepository.findOne(roomId);
        boolean tmpResult = true;
        if (isMember == 1) {
            if (!memberService.isActivated(memberId)) {
                result.put("result" , false);
                result.put("reason", "Member Not Exists Or Not Activated.");
                return result;
            }
            if (!memberService.pay(memberId, roomsEntity.getPrice())) {
                result.put("result" , false);
                result.put("reason", "Deposit is not enough, please recharge first!") ;
                return result;
            }
        }


        LiveMesEntity liveMesEntity = new LiveMesEntity(personNum, personMes, payMethod, memberId, roomId,hotelId);
        liveMesRepository.save(liveMesEntity);
        roomsEntity.setStatus(2);
        roomsRepository.save(roomsEntity);
        result.put("result" , true);
        return result;
    }
}
