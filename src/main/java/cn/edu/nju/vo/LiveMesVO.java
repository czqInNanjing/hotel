package cn.edu.nju.vo;

import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 06/03/2017
 */
public class LiveMesVO {
    private int id;
    private Timestamp inTime = new Timestamp(System.currentTimeMillis());
    private Timestamp outTime = new Timestamp(System.currentTimeMillis());
    private int personNum = 1;
    private String hotelName;
    private String roomName;
    private int payMethod;
    private int total;
    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LiveMesVO() {
    }

    public LiveMesVO(Timestamp inTime, Timestamp outTime, int personNum, String hotelName, String roomName, int payMethod, int total) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.personNum = personNum;
        this.hotelName = hotelName;
        this.roomName = roomName;
        this.payMethod = payMethod;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
