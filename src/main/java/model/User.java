package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private Integer userId;
    private String userLogin;
    private String userPassword;
    private String userRole;
    private Collection<CargoOwner> cargoOwnersByUserId;
    private Collection<Carrier> carriersByUserId;

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_login", nullable = false, length = 25)
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 25)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_role", nullable = true, length = 2)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userLogin != null ? !userLogin.equals(user.userLogin) : user.userLogin != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userRole != null ? !userRole.equals(user.userRole) : user.userRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CargoOwner> getCargoOwnersByUserId() {
        return cargoOwnersByUserId;
    }

    public void setCargoOwnersByUserId(Collection<CargoOwner> cargoOwnersByUserId) {
        this.cargoOwnersByUserId = cargoOwnersByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Carrier> getCarriersByUserId() {
        return carriersByUserId;
    }

    public void setCarriersByUserId(Collection<Carrier> carriersByUserId) {
        this.carriersByUserId = carriersByUserId;
    }
}
