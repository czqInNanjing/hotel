package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "live_mes", schema = "hotel", catalog = "")
public class LiveMesEntity {
    private int id;
    private Timestamp inTime = new Timestamp(System.currentTimeMillis());
    private Timestamp outTime = new Timestamp(System.currentTimeMillis());
    private int personNum = 1;
    private String personMes = "None";
    private int payMethod = 0;
    private int memberId = 0;
    private int roomId = 0;
    private int status;
    private int hotelId;

    public LiveMesEntity() {
    }

    public LiveMesEntity(int personNum, String personMes, int payMethod, int memberId, int roomId, int hotelId) {
        this.personNum = personNum;
        this.personMes = personMes;
        this.payMethod = payMethod;
        this.memberId = memberId;
        this.roomId = roomId;
        this.hotelId = hotelId;
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
    @Column(name = "person_mes", nullable = false, length = 6000)
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
    @Column(name = "member_id", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiveMesEntity that = (LiveMesEntity) o;

        if (id != that.id) return false;
        if (personNum != that.personNum) return false;
        if (payMethod != that.payMethod) return false;
        if (memberId != that.memberId) return false;
        if (roomId != that.roomId) return false;
        if (inTime != null ? !inTime.equals(that.inTime) : that.inTime != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (personMes != null ? !personMes.equals(that.personMes) : that.personMes != null) return false;

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
        result = 31 * result + memberId;
        result = 31 * result + roomId;
        return result;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "hotel_id", nullable = false)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
