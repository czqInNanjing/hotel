package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Entity
@Table(name = "modify_application", schema = "hotel", catalog = "")
public class ModifyApplicationEntity {
    private int id;
    private Timestamp time;
    private Integer hotelId;
    private Integer newHotelId;
    private Byte status;

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
    @Column(name = "hotel_id", nullable = true)
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "new_hotel_id", nullable = true)
    public Integer getNewHotelId() {
        return newHotelId;
    }

    public void setNewHotelId(Integer newHotelId) {
        this.newHotelId = newHotelId;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModifyApplicationEntity that = (ModifyApplicationEntity) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (newHotelId != null ? !newHotelId.equals(that.newHotelId) : that.newHotelId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (newHotelId != null ? newHotelId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
