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
    private final SettlementRepository settlementRepository;
    @Autowired
    public HotelServiceImpl(ModifyApplicationRepository modifyApplicationRepository, OpenApplicationRepository openApplicationRepository, HotelNewRepository hotelNewRepository, HotelRepository hotelRepository, RoomsRepository roomsRepository, LiveMesRepository liveMesRepository, MemberService memberService, SettlementRepository settlementRepository) {
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.openApplicationRepository = openApplicationRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
        this.liveMesRepository = liveMesRepository;
        this.memberService = memberService;
        this.settlementRepository = settlementRepository;
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

        return openApplicationRepository.existsByHotelIdAndStatus(hotelId , 0);
    }

    @Override
    public boolean isApplyingForEditing(int hotelId) {

        return modifyApplicationRepository.existsByHotelIdAndStatus(hotelId , 0);
    }

    @Override
    public void saveOpenApplication(String reason, int id) {
        OpenApplicationEntity openApplication = new OpenApplicationEntity();
        openApplication.setReason(reason);
        openApplication.setHotelId(id);
        openApplicationRepository.save(openApplication);
    }

    @Override
    public void saveModifyApplication(String name, String address, String description, int hotelId, String picUrl) {
        HotelNewEntity newEntity = new HotelNewEntity(name,address,description,hotelId,picUrl);
        newEntity = hotelNewRepository.save(newEntity);
        ModifyApplicationEntity modifyApplicationEntity = new ModifyApplicationEntity(hotelId, newEntity.getId());
        modifyApplicationRepository.save(modifyApplicationEntity);
    }

    @Override
    public List<RoomsEntity> addRooms(String time, boolean wifi, String picUrl, int area, int type, int price, int number, int id) {

        List<RoomsEntity> roomsEntities = new ArrayList<>(number);
        for (int i = 0 ; i < number ; i ++) {
            roomsEntities.add(new RoomsEntity(id,Helper.getTimeStamp(time), wifi ? 1 : 0,picUrl,type, price));
        }
        roomsRepository.save(roomsEntities);
//        RoomsEntity roomsEntity = new RoomsEntity(id,Helper.getTimeStamp(time), (byte) (wifi ? 1 : 0),picUrl,type, price);
        roomsEntities.clear();
        roomsEntities.addAll(roomsRepository.findByHotelId(id));
        return roomsEntities;

    }

    @Override
    public Map<String, Object> addOutRecords(int recordId) {
        Map<String, Object> result = new TreeMap<>();
        LiveMesEntity entity = liveMesRepository.findOne(recordId);
        if (entity != null) {
            if (entity.getStatus() == 0) {
                entity.setOutTime(new Timestamp(System.currentTimeMillis()));
                entity.setStatus(1);
                liveMesRepository.save(entity);
                RoomsEntity roomsEntity = roomsRepository.findOne(entity.getRoomId());
                roomsEntity.setStatus(3);
//                roomsRepository.save(roomsEntity);
                result.put("result" , true);
//                result.put("reason", "Record Not Found!");
            } else {
                result.put("result" , false);
                result.put("reason", "Record Has been added out time!");
            }



        } else {
            result.put("result" , false);
            result.put("reason", "Record Not Found!");
        }
        return result;
    }

    @Override
    public synchronized Map<String, Object> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, int hotelId) {
        Map<String, Object> result = new TreeMap<>();
        RoomsEntity roomsEntity = roomsRepository.findOne(roomId);
        //TODO check if room has been reserved ? or has been used
        boolean tmpResult = true;
        if (isMember == 1) {
            //check if member exists
            if (!memberService.isActivated(memberId)) {
                result.put("result" , false);
                result.put("reason", "Member Not Exists Or Not Activated.");
                return result;
            }
            // pay by member card  (add to settlements)
            if (payMethod == 0) {
                if (memberService.pay(memberId, roomsEntity.getPrice())) {
                    addToHotelSettlements(hotelId, roomsEntity.getPrice());
                } else {
                    result.put("result" , false);
                    result.put("reason", "Deposit is not enough, please recharge first!") ;
                    return result;
                }
            }
            // add points
            memberService.addPoints(memberId, roomsEntity.getPrice());





        }


        LiveMesEntity liveMesEntity = new LiveMesEntity(personNum, personMes, payMethod, memberId, roomId,hotelId);
        liveMesRepository.save(liveMesEntity);
        roomsEntity.setStatus(2);
        roomsRepository.save(roomsEntity);
        result.put("result" , true);
        return result;
    }

    /**
     *  add the amount that was payed by the member card to the settlement
     */
    private void addToHotelSettlements(int hotelId, int amount) {
        SettlementEntity entity = settlementRepository.findByHotelIdAndStatus(hotelId, 0);
        if (entity != null ) {
            entity.setAmount(entity.getAmount() + amount);
            settlementRepository.save(entity);
        } else {
            entity = new SettlementEntity(hotelId, amount);
            settlementRepository.save(entity);
        }


    }

}
