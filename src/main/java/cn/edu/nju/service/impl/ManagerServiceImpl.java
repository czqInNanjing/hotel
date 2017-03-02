package cn.edu.nju.service.impl;

import cn.edu.nju.dao.HotelNewRepository;
import cn.edu.nju.dao.HotelRepository;
import cn.edu.nju.dao.ModifyApplicationRepository;
import cn.edu.nju.dao.OpenApplicationRepository;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.HotelNewEntity;
import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Qiang
 * @since 02/03/2017
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private final OpenApplicationRepository openApplicationRepository;
    private final ModifyApplicationRepository modifyApplicationRepository;
    private final HotelRepository hotelRepository;
    private final HotelNewRepository hotelNewRepository;
    @Autowired
    public ManagerServiceImpl(OpenApplicationRepository openApplicationRepository, ModifyApplicationRepository modifyApplicationRepository, HotelRepository hotelRepository, HotelNewRepository hotelNewRepository) {
        this.openApplicationRepository = openApplicationRepository;
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.hotelRepository = hotelRepository;
        this.hotelNewRepository = hotelNewRepository;
    }


    @Override
    public List<OpenApplicationEntity> getAllOpenApplication() {
        List<OpenApplicationEntity> result = new ArrayList<>(300);
        openApplicationRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<ModifyApplicationEntity> getAllModifyApplication() {
        List<ModifyApplicationEntity> result = new ArrayList<>(300);
        modifyApplicationRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<OpenApplicationEntity> getAllUnDealOpenApplication() {
        //TODO
        return null;
    }

    @Override
    public List<ModifyApplicationEntity> getAllUnDealModifyApplication() {
        //TODO
        return null;
    }

    @Override
    public List<OpenApplicationEntity> getOpenApplicationByPage(int page) {
        //TODO
        return null;
    }

    @Override
    public List<ModifyApplicationEntity> getModifyApplicationByPage(int page) {
        //TODO
        return null;
    }

    @Override
    public List<OpenApplicationEntity> getUnDealOpenApplicationByPage(int page) {
        //TODO
        return null;
    }

    @Override
    public List<ModifyApplicationEntity> getUnDealModifyApplicationByPage(int page) {
        //TODO
        return null;
    }

    @Override
    public Map<String, Object> approve(boolean approve, boolean openOrModify, List<Integer> applicationId) {
        int status = 0;
        if (approve) {
            status = 1;
        } else {
            status = 2;
        }
        final int finalStatus = status; // in lambda expression must be final or effectively final
        if (openOrModify) {
            Iterable<OpenApplicationEntity> openApplicationEntities = openApplicationRepository.findAll(applicationId);

            openApplicationEntities.forEach(entity -> {
                entity.setStatus(finalStatus);
                int id = entity.getHotelId();
                hotelRepository.findOne(id).setStatus(1);

            });
            openApplicationRepository.save(openApplicationEntities);
        } else {
            Iterable<ModifyApplicationEntity> modifyApplicationEntities = modifyApplicationRepository.findAll(applicationId);
            modifyApplicationEntities.forEach(modifyApplicationEntity -> {
                modifyApplicationEntity.setStatus(finalStatus);
                int id = modifyApplicationEntity.getHotelId();

                int newId = modifyApplicationEntity.getNewHotelId();
                HotelEntity hotelEntity = hotelRepository.findOne(id);
                HotelNewEntity hotelNewEntity = hotelNewRepository.findOne(newId);

                BeanUtils.copyProperties(hotelNewEntity,hotelEntity , "id" , "status");
            });
            modifyApplicationRepository.save(modifyApplicationEntities);
        }
        Map<String, Object> result = new TreeMap<>();
        result.put("result", true);

        return result;
    }
}
