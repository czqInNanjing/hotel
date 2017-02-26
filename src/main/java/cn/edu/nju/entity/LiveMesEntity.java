package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@Entity
@Table(name = "liveMes", schema = "hotel", catalog = "")
public class LiveMesEntity {
    private int id;
    private Date inTime;
    private Date outTime;
    private Integer personNum;
    private String personMes;
    private String payMethod;
    private String memberId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "in_time")
    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "out_time")
    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "person_num")
    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    @Basic
    @Column(name = "person_mes")
    public String getPersonMes() {
        return personMes;
    }

    public void setPersonMes(String personMes) {
        this.personMes = personMes;
    }

    @Basic
    @Column(name = "pay_method")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Basic
    @Column(name = "member_id")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiveMesEntity that = (LiveMesEntity) o;

        if (id != that.id) return false;
        if (inTime != null ? !inTime.equals(that.inTime) : that.inTime != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (personNum != null ? !personNum.equals(that.personNum) : that.personNum != null) return false;
        if (personMes != null ? !personMes.equals(that.personMes) : that.personMes != null) return false;
        if (payMethod != null ? !payMethod.equals(that.payMethod) : that.payMethod != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (inTime != null ? inTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (personNum != null ? personNum.hashCode() : 0);
        result = 31 * result + (personMes != null ? personMes.hashCode() : 0);
        result = 31 * result + (payMethod != null ? payMethod.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        return result;
    }
}
