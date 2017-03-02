package cn.edu.nju.service;

import cn.edu.nju.entity.*;

import java.util.List;

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
     * 2. if it is a member, check if the member is activated, its deposit is enough,
     * @param personNum
     * @param personMes
     * @param isMember
     * @param payMethod
     * @param memberId
     * @param roomId
     * @param hotelId
     * @return
     */
    List<LiveMesEntity> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, int hotelId);
}
