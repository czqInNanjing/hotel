package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 06/03/2017
 */
@Entity
@Table(name = "point_convert", schema = "hotel", catalog = "")
public class PointConvertEntity {
    private int id;
    private Timestamp time;
    private int memberId;
    private int point;
    private int amount;
    private Integer after;

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
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "after", nullable = true)
    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointConvertEntity that = (PointConvertEntity) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (point != that.point) return false;
        if (amount != that.amount) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (after != null ? !after.equals(that.after) : that.after != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + point;
        result = 31 * result + amount;
        result = 31 * result + (after != null ? after.hashCode() : 0);
        return result;
    }
}
