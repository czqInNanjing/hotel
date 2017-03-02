package cn.edu.nju.service;

import cn.edu.nju.entity.*;

import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public interface HotelService {


    HotelEntity getHotelByHotelId(int hotelId);

    List<RoomsEntity> findRoomsByHotelId(int hotelId);

    List<RoomsEntity> findRoomsByHotelIdAndPage(int hotelId, int page);

    List<LiveMesEntity> findLiveMesByHotelId(int hotelId);

    List<LiveMesEntity> findLiveMesByHotelIdAndPage(int hotelId, int page);

    boolean isApplyingForOpen(int hotelId);

    boolean isApplyingForEditing(int hotelId);


    void saveOpenApplication(String reason, int id);

    void saveModifyApplication(String name, String address, String description, int hotelId);

    List<RoomsEntity> addRooms(String time, boolean wifi, String picUrl, int area, int type , int price, int number, int id);

    List<LiveMesEntity> addOutRecords(int recordId);

    /**
     * This method needs to tackle several things:
     * 1. Check if the room is available
     * 2. if it is a member, check if the member is activated, its deposit is enough, then subtract the corresponding value from the account
     * 3. <continue> then add points to the member's account, add pay records
     * 4. add the live message to the db
     * 5. mark the specific room 'lived'
     * @param personNum     number who live in that room
     * @param personMes     person(s)' message
     * @param isMember      is a member
     * @param payMethod     pay method, 0 -- member card   1 -- cash 2-- credit card
     * @param memberId      member id if a member
     * @param roomId        room id
     * @param hotelId       hotel id
     * @return              success or failure, and reason if fail
     */
    Map<String, Object> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, int hotelId);
}
