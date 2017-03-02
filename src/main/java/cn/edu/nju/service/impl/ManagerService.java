package cn.edu.nju.service.impl;

import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 02/03/2017
 */
public interface ManagerService {

    List<OpenApplicationEntity> getAllOpenApplication();
    List<ModifyApplicationEntity> getAllModifyApplication();

    List<OpenApplicationEntity> getAllUnDealOpenApplication();
    List<ModifyApplicationEntity> getAllUnDealModifyApplication();

    List<OpenApplicationEntity> getOpenApplicationByPage(int page);
    List<ModifyApplicationEntity> getModifyApplicationByPage(int page);

    List<OpenApplicationEntity> getUnDealOpenApplicationByPage(int page);
    List<ModifyApplicationEntity> getUnDealModifyApplicationByPage(int page);


    Map<String,Object> approve(boolean approve, boolean openOrModify, List<Integer> applicationId);
}
