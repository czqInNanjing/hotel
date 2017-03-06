package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 06/03/2017
 */
@Entity
@Table(name = "recharge", schema = "hotel", catalog = "")
public class RechargeEntity {
    private int id;
    private Timestamp time;
    private int memberId;
    private int former;
    private int after;
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
    @Column(name = "member_id", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "former", nullable = false)
    public int getFormer() {
        return former;
    }

    public void setFormer(int former) {
        this.former = former;
    }

    @Basic
    @Column(name = "after", nullable = false)
    public int getAfter() {
        return after;
    }

    public void setAfter(int later) {
        this.after = later;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RechargeEntity that = (RechargeEntity) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (former != that.former) return false;
        if (after != that.after) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + former;
        result = 31 * result + after;
        return result;
    }
}
