package cn.edu.nju.vo;

import java.util.List;

/**
 * @author Qiang
 * @since 03/03/2017
 */
public class HotelDetailVO {
    private int id;
    private String name = "Hotel";
    private String address = "No Set";
    private String description = "No Description Yet";
    private String picUrl = "";
    private List<RoomVO> vos;

    public HotelDetailVO() {
    }

    public HotelDetailVO(int id, String name, String address, String description, String picUrl, List<RoomVO> vos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.picUrl = picUrl;
        this.vos = vos;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<RoomVO> getVos() {
        return vos;
    }

    public void setVos(List<RoomVO> vos) {
        this.vos = vos;
    }
}
