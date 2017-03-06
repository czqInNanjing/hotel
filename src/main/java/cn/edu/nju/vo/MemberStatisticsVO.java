package cn.edu.nju.vo;

import cn.edu.nju.entity.LiveMesEntity;
import cn.edu.nju.entity.ReservedEntity;

import java.util.List;

/**
 * @author Qiang
 * @since 06/03/2017
 */
public class MemberStatisticsVO {

    private List<ReservedEntity> reservedEntities;
    private List<LiveMesEntity> liveMesEntities;
    private List<ConsumptionVO> consumptionVOS;


    public List<ReservedEntity> getReservedEntities() {
        return reservedEntities;
    }

    public void setReservedEntities(List<ReservedEntity> reservedEntities) {
        this.reservedEntities = reservedEntities;
    }

    public List<LiveMesEntity> getLiveMesEntities() {
        return liveMesEntities;
    }

    public void setLiveMesEntities(List<LiveMesEntity> liveMesEntities) {
        this.liveMesEntities = liveMesEntities;
    }

    public List<ConsumptionVO> getConsumptionVOS() {
        return consumptionVOS;
    }

    public void setConsumptionVOS(List<ConsumptionVO> consumptionVOS) {
        this.consumptionVOS = consumptionVOS;
    }
}
