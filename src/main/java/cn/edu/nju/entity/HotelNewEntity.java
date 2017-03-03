package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "hotel_new", schema = "hotel", catalog = "")
public class HotelNewEntity {
    private int id;
    private String name = "Hotel";
    private String address = "No Set";
    private int status = 0;
    private String description = "No Description Yet";
    private Integer oldHotel;
    private String picUrl = "";

    public HotelNewEntity() {
    }
    public HotelNewEntity(String name, String address, String description, Integer oldHotel, String picUrl) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.oldHotel = oldHotel;
        this.picUrl = picUrl;
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
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelNewEntity that = (HotelNewEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "old_hotel", nullable = true)
    public Integer getOldHotel() {
        return oldHotel;
    }

    public void setOldHotel(Integer oldHotel) {
        this.oldHotel = oldHotel;
    }

    @Basic
    @Column(name = "pic_url", nullable = true, length = 6000)
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
