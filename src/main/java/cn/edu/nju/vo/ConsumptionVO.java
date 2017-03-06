package cn.edu.nju.vo;

import java.sql.Timestamp;
import java.util.TreeMap;

/**
 * VO for {@link cn.edu.nju.entity.PayRecordEntity}   {@link cn.edu.nju.entity.RechargeEntity}
 *  and {@link cn.edu.nju.entity.PointConvertEntity}
 *
 *
 * @author Qiang
 * @since 06/03/2017
 */
public class ConsumptionVO {

    private int id;
    private int type;
    private Timestamp time;
    private int amount;
    private int after;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }
}
