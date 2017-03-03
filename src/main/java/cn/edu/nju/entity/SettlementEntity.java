package cn.edu.nju.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Qiang
 * @since 02/03/2017
 */
@Entity
@Table(name = "settlement", schema = "hotel", catalog = "")
public class SettlementEntity {
    private int id;
    private int hotelId;
    private int amount;
    private int status = 0 ;
    private Timestamp settledTime = new Timestamp(System.currentTimeMillis());


    public SettlementEntity() {
    }

    public SettlementEntity(int hotelId, int amount) {

        this.hotelId = hotelId;
        this.amount = amount;
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
    @Column(name = "hotel_id", nullable = false)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
    @Column(name = "settledTime", nullable = false)
    public Timestamp getSettledTime() {
        return settledTime;
    }

    public void setSettledTime(Timestamp settledTime) {
        this.settledTime = settledTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettlementEntity that = (SettlementEntity) o;

        if (id != that.id) return false;
        if (hotelId != that.hotelId) return false;
        if (amount != that.amount) return false;
        if (status != that.status) return false;
        if (settledTime != null ? !settledTime.equals(that.settledTime) : that.settledTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hotelId;
        result = 31 * result + amount;
        result = 31 * result + status;
        result = 31 * result + (settledTime != null ? settledTime.hashCode() : 0);
        return result;
    }
}
