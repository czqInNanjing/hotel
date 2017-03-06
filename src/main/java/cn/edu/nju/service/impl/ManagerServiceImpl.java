package cn.edu.nju.service.impl;

import cn.edu.nju.dao.*;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.ManagerService;
import cn.edu.nju.util.SystemDefault;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    private final SettlementRepository settlementRepository;
    @Autowired
    public ManagerServiceImpl(OpenApplicationRepository openApplicationRepository, ModifyApplicationRepository modifyApplicationRepository, HotelRepository hotelRepository, HotelNewRepository hotelNewRepository, SettlementRepository settlementRepository) {
        this.openApplicationRepository = openApplicationRepository;
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.hotelRepository = hotelRepository;
        this.hotelNewRepository = hotelNewRepository;
        this.settlementRepository = settlementRepository;
    }


    @Override
    public List<OpenApplicationEntity> getAllOpenApplication(boolean onlyOpen, int page) {

        List<OpenApplicationEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<OpenApplicationEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = openApplicationRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = openApplicationRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                openApplicationRepository.findByStatus(0).forEach(result::add);
            } else {
                openApplicationRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }

    @Override
    public List<ModifyApplicationEntity> getAllModifyApplication(boolean onlyOpen, int page) {
        List<ModifyApplicationEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<ModifyApplicationEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = modifyApplicationRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = modifyApplicationRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                modifyApplicationRepository.findByStatus(0).forEach(result::add);
            } else {
                modifyApplicationRepository.findAll().forEach(result::add);
            }
        }
        return result;
    }

    @Override
    public List<SettlementEntity> getAllSettlements(boolean onlyOpen, int page) {
        List<SettlementEntity> result = new ArrayList<>(SystemDefault.LIST_DEFAULT_SIZE);
        Page<SettlementEntity> pages;
        if (page >= 0) {
            if (onlyOpen) {
                pages = settlementRepository.findAll(new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            } else {
                pages = settlementRepository.findByStatus(0, new PageRequest(page , SystemDefault.SIZE_PER_PAGE));
            }

            pages.forEach(result::add);

        } else {
            if (onlyOpen) {
                settlementRepository.findByStatus(0).forEach(result::add);
            } else {
                settlementRepository.findAll().forEach(result::add);
            }
        }
        return result;
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
        result.put(SystemDefault.HTTP_RESULT, true);

        return result;
    }

    @Override
    public Map<String, Object> settle(boolean isApprove, List<Integer> operationArray) {
        Iterable<SettlementEntity> settlementEntities = settlementRepository.findAll(operationArray);
        int status = 0;
        if (isApprove) {
            status = 1;
        } else {
            status = 2;
        }
        final int finalStatus = status;
        settlementEntities.forEach(entity -> {
            entity.setStatus(finalStatus);

            //TODO what to do next if approved or not
        });
        settlementRepository.save(settlementEntities);
        Map<String, Object> result = new TreeMap<>();
        result.put(SystemDefault.HTTP_RESULT, true);

        return result;
    }
}
