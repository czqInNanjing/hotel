package cn.edu.nju.vo;

import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 02/03/2017
 */
public class MemberInfoVO {
    private int id;
    private String name = "Name";
    private String mail = "czq@qq.com";
    private int status = 0;
    private int deposit = 0;
    private int points = 0;
    private String creditCard = "None";
    private Timestamp registDate = new Timestamp(System.currentTimeMillis());
    private int remainDays = 0;
    private int accumulate = 0;
    private int memberLevel = 0;
    private int discount = 0;
    public int getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(int accumulate) {
        this.accumulate = accumulate;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }




    public MemberInfoVO() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    public int getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(int remainDays) {
        this.remainDays = remainDays;
    }
}
