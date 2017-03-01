package cn.edu.nju.service.impl;

import cn.edu.nju.dao.HotelNewRepository;
import cn.edu.nju.dao.ModifyApplicationRepository;
import cn.edu.nju.dao.OpenApplicationRepository;
import cn.edu.nju.entity.HotelNewEntity;
import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import cn.edu.nju.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qiang
 * @since 01/03/2017
 */
@Service
public class HotelServiceImpl implements HotelService {

    private final ModifyApplicationRepository modifyApplicationRepository;
    private final OpenApplicationRepository openApplicationRepository;
    private final HotelNewRepository hotelNewRepository;
    @Autowired
    public HotelServiceImpl(ModifyApplicationRepository modifyApplicationRepository, OpenApplicationRepository openApplicationRepository, HotelNewRepository hotelNewRepository) {
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.openApplicationRepository = openApplicationRepository;
        this.hotelNewRepository = hotelNewRepository;
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
        hotelNewRepository.save(newEntity);
        ModifyApplicationEntity modifyApplicationEntity = new ModifyApplicationEntity(hotelId, newEntity.getId());
        modifyApplicationRepository.save(modifyApplicationEntity);
    }
}
