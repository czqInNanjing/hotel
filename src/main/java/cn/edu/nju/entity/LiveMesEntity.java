package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Entity
@Table(name = "live_mes", schema = "hotel", catalog = "")
public class LiveMesEntity {
    private int id;
    private Timestamp inTime;
    private Timestamp outTime;
    private int personNum;
    private String personMes;
    private int payMethod;
    private Integer memberId;
    private int roomId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "in_time", nullable = false)
    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "out_time", nullable = false)
    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "person_num", nullable = false)
    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    @Basic
    @Column(name = "person_mes", nullable = true, length = -1)
    public String getPersonMes() {
        return personMes;
    }

    public void setPersonMes(String personMes) {
        this.personMes = personMes;
    }

    @Basic
    @Column(name = "pay_method", nullable = false)
    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    @Basic
    @Column(name = "member_id", nullable = true)
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiveMesEntity that = (LiveMesEntity) o;

        if (id != that.id) return false;
        if (personNum != that.personNum) return false;
        if (payMethod != that.payMethod) return false;
        if (inTime != null ? !inTime.equals(that.inTime) : that.inTime != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (personMes != null ? !personMes.equals(that.personMes) : that.personMes != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (inTime != null ? inTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + personNum;
        result = 31 * result + (personMes != null ? personMes.hashCode() : 0);
        result = 31 * result + payMethod;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
