package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "modify_application", schema = "hotel", catalog = "")
public class ModifyApplicationEntity {
    private int id;
    private Timestamp time;
    private int hotelId;
    private int newHotelId;
    private int status = 0;

    public ModifyApplicationEntity() {
    }

    public ModifyApplicationEntity(int hotelId, int newHotelId) {
        this.hotelId = hotelId;
        this.newHotelId = newHotelId;
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
    @Column(name = "hotel_id", nullable = false)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "new_hotel_id", nullable = false)
    public int getNewHotelId() {
        return newHotelId;
    }

    public void setNewHotelId(int newHotelId) {
        this.newHotelId = newHotelId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModifyApplicationEntity that = (ModifyApplicationEntity) o;

        if (id != that.id) return false;
        if (hotelId != that.hotelId) return false;
        if (newHotelId != that.newHotelId) return false;
        if (status != that.status) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + newHotelId;
        result = 31 * result + (int) status;
        return result;
    }
}
