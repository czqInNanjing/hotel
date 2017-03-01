package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * @author Qiang
 * @since 28/02/2017
 */
@Entity
@Table(name = "account", schema = "hotel", catalog = "")
public class AccountEntity {

    private String mail;
    private String password;
    private int id;
    private int type;

    public AccountEntity() {
    }

    public AccountEntity(String mail, String password, int type) {
        this.mail = mail;
        this.password = password;
        this.type = type;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity entity = (AccountEntity) o;

        if (id != entity.id) return false;
        if (type != entity.type) return false;
        if (mail != null ? !mail.equals(entity.mail) : entity.mail != null) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mail != null ? mail.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + type;
        return result;
    }
}
