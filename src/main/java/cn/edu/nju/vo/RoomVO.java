package cn.edu.nju.vo;

import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 03/03/2017
 */
public class RoomVO {


    private int id;
    private Timestamp availableTime;
    private int wifi;
    private String picUrl;
    private int type = 0;
    private int price = 0;
    private int status = 0;
    private Integer breakfast;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public RoomVO() {
    }

    public Timestamp getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Timestamp availableTime) {
        this.availableTime = availableTime;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
