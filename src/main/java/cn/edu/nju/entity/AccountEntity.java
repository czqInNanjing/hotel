package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@Entity
@Table(name = "account", schema = "hotel", catalog = "")
public class AccountEntity {
    private String mail;
    private String password;
    private String id;
    private HotelEntity hotelById;
    private HotelNewEntity hotelNewById;
    private MemberEntity memberById;

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity entity = (AccountEntity) o;

        if (mail != null ? !mail.equals(entity.mail) : entity.mail != null) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mail != null ? mail.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public AccountEntity() {
    }

    public AccountEntity(String mail, String password, String id) {
        this.mail = mail;
        this.password = password;
        this.id = id;
    }

    @OneToOne(mappedBy = "accountById")
    public HotelEntity getHotelById() {
        return hotelById;
    }

    public void setHotelById(HotelEntity hotelById) {
        this.hotelById = hotelById;
    }

    @OneToOne(mappedBy = "accountById")
    public HotelNewEntity getHotelNewById() {
        return hotelNewById;
    }

    public void setHotelNewById(HotelNewEntity hotelNewById) {
        this.hotelNewById = hotelNewById;
    }

    @OneToOne(mappedBy = "accountById")
    public MemberEntity getMemberById() {
        return memberById;
    }

    public void setMemberById(MemberEntity memberById) {
        this.memberById = memberById;
    }
}
