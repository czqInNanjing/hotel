package cn.edu.nju.service.impl;

import cn.edu.nju.dao.HotelNewRepository;
import cn.edu.nju.dao.ModifyApplicationRepository;
import cn.edu.nju.dao.OpenApplicationRepository;
import cn.edu.nju.dao.RoomsRepository;
import cn.edu.nju.entity.HotelNewEntity;
import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import cn.edu.nju.entity.RoomsEntity;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiang
 * @since 01/03/2017
 */
@Service
public class HotelServiceImpl implements HotelService {

    private final ModifyApplicationRepository modifyApplicationRepository;
    private final OpenApplicationRepository openApplicationRepository;
    private final HotelNewRepository hotelNewRepository;
    private final RoomsRepository roomsRepository;
    @Autowired
    public HotelServiceImpl(ModifyApplicationRepository modifyApplicationRepository, OpenApplicationRepository openApplicationRepository, HotelNewRepository hotelNewRepository, RoomsRepository roomsRepository) {
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.openApplicationRepository = openApplicationRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.roomsRepository = roomsRepository;
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
}
