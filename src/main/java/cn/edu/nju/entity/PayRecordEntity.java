package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Entity
@Table(name = "pay_record", schema = "hotel", catalog = "")
public class PayRecordEntity {
    private int id;
    private Timestamp time;
    private Integer bill;
    private Integer liveId;
    private Integer after;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "bill", nullable = true)
    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    @Basic
    @Column(name = "live_id", nullable = true)
    public Integer getLiveId() {
        return liveId;
    }

    public void setLiveId(Integer liveId) {
        this.liveId = liveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayRecordEntity that = (PayRecordEntity) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (bill != null ? !bill.equals(that.bill) : that.bill != null) return false;
        if (liveId != null ? !liveId.equals(that.liveId) : that.liveId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (bill != null ? bill.hashCode() : 0);
        result = 31 * result + (liveId != null ? liveId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "after", nullable = true)
    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }
}
