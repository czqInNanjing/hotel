package cn.edu.nju.vo;

import java.util.List;

/**
 * @author Qiang
 * @since 06/03/2017
 */
public class MemberStatisticsVO {

    private List<ReservedVO> reservedVOS;
    private List<LiveMesVO> liveMesVOS;
    private List<ConsumptionVO> consumptionVOS;


    public List<ReservedVO> getReservedVOS() {
        return reservedVOS;
    }

    public void setReservedVOS(List<ReservedVO> reservedVOS) {
        this.reservedVOS = reservedVOS;
    }

    public List<LiveMesVO> getLiveMesVOS() {
        return liveMesVOS;
    }

    public void setLiveMesVOS(List<LiveMesVO> liveMesVOS) {
        this.liveMesVOS = liveMesVOS;
    }

    public List<ConsumptionVO> getConsumptionVOS() {
        return consumptionVOS;
    }

    public void setConsumptionVOS(List<ConsumptionVO> consumptionVOS) {
        this.consumptionVOS = consumptionVOS;
    }
}
