package cn.edu.nju.service;

import cn.edu.nju.entity.HotelNewEntity;
import cn.edu.nju.entity.OpenApplicationEntity;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public interface HotelService {


    boolean isApplyingForOpen(int hotelId);

    boolean isApplyingForEditing(int hotelId);


    void saveOpenApplication(String reason, int id);

    void saveModifyApplication(String name, String address, String description, int hotelId);
}
