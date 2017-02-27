package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Entity
@Table(name = "recharge", schema = "hotel", catalog = "")
public class RechargeEntity {
    private String id;
    private Timestamp time;
    private String memberId;
    private Integer former;
    private Integer later;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "member_id", nullable = true, length = 20)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "former", nullable = true)
    public Integer getFormer() {
        return former;
    }

    public void setFormer(Integer former) {
        this.former = former;
    }

    @Basic
    @Column(name = "later", nullable = true)
    public Integer getLater() {
        return later;
    }

    public void setLater(Integer later) {
        this.later = later;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RechargeEntity that = (RechargeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (former != null ? !former.equals(that.former) : that.former != null) return false;
        if (later != null ? !later.equals(that.later) : that.later != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (former != null ? former.hashCode() : 0);
        result = 31 * result + (later != null ? later.hashCode() : 0);
        return result;
    }
}
