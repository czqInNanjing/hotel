package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.Helper;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.HotelDetailVO;
import cn.edu.nju.vo.RoomVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final ReservedRepository reservedRepository;

    @Autowired
    public HotelServiceImpl(ModifyApplicationRepository modifyApplicationRepository, OpenApplicationRepository openApplicationRepository, HotelNewRepository hotelNewRepository, HotelRepository hotelRepository, RoomsRepository roomsRepository, LiveMesRepository liveMesRepository, MemberService memberService, SettlementRepository settlementRepository, ReservedRepository reservedRepository) {
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.openApplicationRepository = openApplicationRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
        this.liveMesRepository = liveMesRepository;
        this.memberService = memberService;
        this.settlementRepository = settlementRepository;
        this.reservedRepository = reservedRepository;
    }

    @Override
    public List<HotelEntity> getAllHotels() {
        List<HotelEntity> result = new ArrayList<>();
        hotelRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<HotelEntity> getHotelsByPage(int page) {
        List<HotelEntity> result = new ArrayList<>();
        Page<HotelEntity> pages;
        if (page >= 0) {

            pages = hotelRepository.findAll(new PageRequest(page, SystemDefault.SIZE_PER_PAGE_OF_HOTEL));
            pages.forEach(result::add);

        } else {
            hotelRepository.findAll().forEach(result::add);

        }
        return result;
    }

    @Override
    public HotelEntity getHotelByHotelId(int hotelId) {
        return hotelRepository.findOne(hotelId);
    }

    @Override
    public HotelDetailVO getHotelDetailVOByHotelId(int hotelId, int page) {
        HotelEntity entity = hotelRepository.findOne(hotelId);
        HotelDetailVO detailVO = new HotelDetailVO();
        BeanUtils.copyProperties(entity, detailVO);
        List<RoomsEntity> roomsEntities = findRoomsByHotelId(hotelId, true, page);
        List<RoomVO> roomVOS = new ArrayList<>(roomsEntities.size());
        roomsEntities.forEach(roomsEntity -> {
            RoomVO vo = new RoomVO();
            BeanUtils.copyProperties(roomsEntity, vo);
            roomVOS.add(vo);
        });

        detailVO.setVos(roomVOS);
        return detailVO;
    }


    @Override
    public List<RoomsEntity> findRoomsByHotelId(int hotelId, boolean onlyAvailable, int page) {
        List<RoomsEntity> result = new ArrayList<>();
        Page<RoomsEntity> pages;
        if (page >= 0) {
            if (onlyAvailable) {
                pages = roomsRepository.findByHotelIdAndStatus(hotelId, 0, new PageRequest(page, SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = roomsRepository.findByHotelId(hotelId, new PageRequest(page, SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyAvailable) {
                roomsRepository.findByStatus(0).forEach(result::add);
            } else {
                roomsRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }


    @Override
    public List<LiveMesEntity> findLiveMesByHotelId(int hotelId, int page) {
        List<LiveMesEntity> result = new ArrayList<>();
        Page<LiveMesEntity> pages;
        if (page >= 0) {

            pages = liveMesRepository.findByHotelId(hotelId, new PageRequest(page, SystemDefault.SIZE_PER_PAGE));
            pages.forEach(result::add);

        } else {
            liveMesRepository.findByHotelId(hotelId).forEach(result::add);

        }
        return result;
    }


    @Override
    public boolean isApplyingForOpen(int hotelId) {
        return openApplicationRepository.existsByHotelIdAndStatus(hotelId, 0);
    }

    @Override
    public boolean isApplyingForEditing(int hotelId) {

        return modifyApplicationRepository.existsByHotelIdAndStatus(hotelId, 0);
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
        HotelNewEntity newEntity = new HotelNewEntity(name, address, description, hotelId, picUrl);
        newEntity = hotelNewRepository.save(newEntity);
        ModifyApplicationEntity modifyApplicationEntity = new ModifyApplicationEntity(hotelId, newEntity.getId());
        modifyApplicationRepository.save(modifyApplicationEntity);
    }

    @Override
    public List<RoomsEntity> addRooms(String time, boolean wifi, String picUrl, int area, int type, int price, int number, int id) {

        List<RoomsEntity> roomsEntities = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            roomsEntities.add(new RoomsEntity(id, Helper.getTimeStamp(time), wifi ? 1 : 0, picUrl, type, price));
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
                result.put(SystemDefault.HTTP_RESULT, true);
//                result.put(SystemDefault.HTTP_REASON, "Record Not Found!");
            } else {
                result.put(SystemDefault.HTTP_RESULT, false);
                result.put(SystemDefault.HTTP_REASON, "Record Has been added out time!");
            }


        } else {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Record Not Found!");
        }
        return result;
    }

    @Override
    public synchronized Map<String, Object> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, int hotelId, boolean hasReserved) {
        Map<String, Object> result = new TreeMap<>();
        RoomsEntity roomsEntity = roomsRepository.findOne(roomId);
        boolean changeReservedStatus = false;
        if (roomsEntity.getStatus() == SystemDefault.ROOM_OCCUPIED) {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Room has been occupied.");
            return result;
        }

        if (isMember == 1 && hasReserved) {
            if (roomsEntity.getStatus() == SystemDefault.ROOM_ACTIVE) {
                result.put(SystemDefault.HTTP_RESULT, false);
                result.put(SystemDefault.HTTP_REASON, "Not any reserved record found.");
                return result;
            } else {
                changeReservedStatus = true;
            }
        }


        if (isMember == 1) {
            //check if member exists
            if (!memberService.isActivated(memberId)) {
                result.put(SystemDefault.HTTP_RESULT, false);
                result.put(SystemDefault.HTTP_REASON, "Member Not Exists Or Not Activated.");
                return result;
            }
            // pay by member card  (add to settlements)
            if (payMethod == 0) {
                if (memberService.pay(memberId, roomsEntity.getPrice())) {
                    addToHotelSettlements(hotelId, roomsEntity.getPrice());
                } else {
                    result.put(SystemDefault.HTTP_RESULT, false);
                    result.put(SystemDefault.HTTP_REASON, "Deposit is not enough, please recharge first!");
                    return result;
                }
            }
            // add points
            memberService.addPoints(memberId, roomsEntity.getPrice());


        }


        LiveMesEntity liveMesEntity = new LiveMesEntity(personNum, personMes, payMethod, memberId, roomId, hotelId);
        liveMesRepository.save(liveMesEntity);
        roomsEntity.setStatus(2);
        roomsRepository.save(roomsEntity);
        reservedRepository.findByRoomId(roomId).forEach(reservedEntity -> {
            reservedEntity.setStatus(1);
            reservedRepository.save(reservedEntity);
        });
        if (changeReservedStatus) {
            result.put(SystemDefault.HTTP_RESULT, true);
        }

        return result;
    }

    @Override
    public Map<String, Object> getHotelReservedStatus(int id) {
        List<ReservedEntity> reservedEntities = reservedRepository.findByHotelId(id);

        Map<String, Object> result = new TreeMap<>();
        if (! reservedEntities.isEmpty()) {
            result.put(SystemDefault.HTTP_RESULT, true);

            Map<String, Integer> dateAndNumber = new TreeMap<>();
            reservedEntities.forEach(entity -> {
                String date = Helper.timeToDateString(entity.getTime());
                if (dateAndNumber.containsKey(date)) {
                    dateAndNumber.put(date, dateAndNumber.get(date) + 1);
                } else {
                    dateAndNumber.put(date, 1);
                }
            });

            result.put("data", dateAndNumber);


        } else {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Not any entities data found.");
        }



        return result;
    }

    @Override
    public Map<String, Object> getHotelLiveStatus(int id) {
        List<LiveMesEntity> liveMesEntities = liveMesRepository.findByHotelId(id);

        Map<String, Object> result = new TreeMap<>();
        if (! liveMesEntities.isEmpty()) {
            result.put(SystemDefault.HTTP_RESULT, true);

            Map<String, Integer> dateAndNumber = new TreeMap<>();
            liveMesEntities.forEach(entity -> {
                String date = Helper.timeToDateString(entity.getInTime());
                if (dateAndNumber.containsKey(date)) {
                    dateAndNumber.put(date, dateAndNumber.get(date) + 1);
                } else {
                    dateAndNumber.put(date, 1);
                }
            });
            result.put("data", dateAndNumber);



        } else {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Not any entities data found.");
        }



        return result;
    }

    @Override
    public Map<String, Object> getHotelConsumptionStatus(int id) {
        List<LiveMesEntity> liveMesEntities = liveMesRepository.findByHotelId(id);

        Map<String, Object> result = new TreeMap<>();


        if (! liveMesEntities.isEmpty()) {
            result.put(SystemDefault.HTTP_RESULT, true);

            Map<String, Integer> typeAndNumber = new TreeMap<>();
            typeAndNumber.put("MemberCard" , 0);
            typeAndNumber.put("Cash" , 0);
            typeAndNumber.put("Credit Card", 0 );
            liveMesEntities.forEach(entity -> {
                switch (entity.getPayMethod()) {
                    case 0:
                        typeAndNumber.put("MemberCard", typeAndNumber.get("MemberCard") + 1);break;
                    case 1:
                        typeAndNumber.put("Cash", typeAndNumber.get("Cash") + 1);break;
                    default:
                        typeAndNumber.put("Credit Card", typeAndNumber.get("Credit Card") + 1);break;

                }



            });
            result.put("data", typeAndNumber);



        } else {
            result.put(SystemDefault.HTTP_RESULT, false);
            result.put(SystemDefault.HTTP_REASON, "Not any entities data found.");
        }



        return result;
    }

    @Override
    public List<Integer> getRoomStatus(int id) {
        int numOfActive = roomsRepository.findByHotelIdAndStatus(id, SystemDefault.ROOM_ACTIVE).size();
        int numOfReserved = roomsRepository.findByHotelIdAndStatus(id, SystemDefault.ROOM_RESERVED).size();
        int numOfUnderUse = roomsRepository.findByHotelIdAndStatus(id, SystemDefault.ROOM_OCCUPIED).size();
                List<Integer> result = new ArrayList<>();
        result.add(numOfReserved);
        result.add(numOfUnderUse);
        result.add(numOfActive);
        return result;
    }

    /**
     * add the amount that was payed by the member card to the settlement
     */
    private void addToHotelSettlements(int hotelId, int amount) {
        SettlementEntity entity = settlementRepository.findByHotelIdAndStatus(hotelId, 0);
        if (entity != null) {
            entity.setAmount(entity.getAmount() + amount);
            settlementRepository.save(entity);
        } else {
            entity = new SettlementEntity(hotelId, amount);
            settlementRepository.save(entity);
        }


    }

}
