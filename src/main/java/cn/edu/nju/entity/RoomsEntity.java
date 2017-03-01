package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "rooms", schema = "hotel", catalog = "")
public class RoomsEntity {
    private int id;
    private int hotelId;
    private Timestamp availableTime;
    private byte wifi;
    private String picUrl;
    private int type;
    private int price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "available_time", nullable = false)
    public Timestamp getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Timestamp availableTime) {
        this.availableTime = availableTime;
    }

    @Basic
    @Column(name = "wifi", nullable = false)
    public byte getWifi() {
        return wifi;
    }

    public void setWifi(byte wifi) {
        this.wifi = wifi;
    }

    @Basic
    @Column(name = "pic_url", nullable = true, length = 6000)
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (id != that.id) return false;
        if (hotelId != that.hotelId) return false;
        if (wifi != that.wifi) return false;
        if (type != that.type) return false;
        if (price != that.price) return false;
        if (availableTime != null ? !availableTime.equals(that.availableTime) : that.availableTime != null)
            return false;
        if (picUrl != null ? !picUrl.equals(that.picUrl) : that.picUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hotelId;
        result = 31 * result + (availableTime != null ? availableTime.hashCode() : 0);
        result = 31 * result + (int) wifi;
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + price;
        return result;
    }
}
