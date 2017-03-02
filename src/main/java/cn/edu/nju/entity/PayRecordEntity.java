package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "pay_record", schema = "hotel", catalog = "")
public class PayRecordEntity {
    private int id;
    private Timestamp time;
    private int bill;
    private int after;
    private int liveId;


    public PayRecordEntity() {
    }

    public PayRecordEntity(int bill, int after) {
        this.bill = bill;
        this.after = after;
    }

    @GeneratedValue
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
    @Column(name = "bill", nullable = false)
    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    @Basic
    @Column(name = "after", nullable = false)
    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    @Basic
    @Column(name = "live_id", nullable = false)
    public int getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayRecordEntity that = (PayRecordEntity) o;

        if (id != that.id) return false;
        if (bill != that.bill) return false;
        if (after != that.after) return false;
        if (liveId != that.liveId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + bill;
        result = 31 * result + after;
        result = 31 * result + liveId;
        return result;
    }
}
