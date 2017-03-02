package cn.edu.nju.service;

import cn.edu.nju.entity.HotelNewEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import cn.edu.nju.entity.RoomsEntity;

import java.util.List;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public interface HotelService {


    boolean isApplyingForOpen(int hotelId);

    boolean isApplyingForEditing(int hotelId);


    void saveOpenApplication(String reason, int id);

    void saveModifyApplication(String name, String address, String description, int hotelId);

    List<RoomsEntity> addRooms(String time, boolean wifi, String picUrl, int area, int type , int price, int number, int id);
}
