package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cargo_owner", schema = "scm", catalog = "")
public class CargoOwner {
    private Integer cargoOwnerId;
    private String cargoOwnerName;
    private String cargoOwnerDesc;
    private String cargoOwnerPhone;
    private Integer userId;
    private User userByUserId;
    private Collection<Ticket> ticketsByCargoOwnerId;

    @Id
    @Column(name = "cargo_owner_id", nullable = false)
    public Integer getCargoOwnerId() {
        return cargoOwnerId;
    }

    public void setCargoOwnerId(Integer cargoOwnerId) {
        this.cargoOwnerId = cargoOwnerId;
    }

    @Basic
    @Column(name = "cargo_owner_name", nullable = false, length = 60)
    public String getCargoOwnerName() {
        return cargoOwnerName;
    }

    public void setCargoOwnerName(String cargoOwnerName) {
        this.cargoOwnerName = cargoOwnerName;
    }

    @Basic
    @Column(name = "cargo_owner_desc", nullable = true, length = 255)
    public String getCargoOwnerDesc() {
        return cargoOwnerDesc;
    }

    public void setCargoOwnerDesc(String cargoOwnerDesc) {
        this.cargoOwnerDesc = cargoOwnerDesc;
    }

    @Basic
    @Column(name = "cargo_owner_phone", nullable = true, length = 20)
    public String getCargoOwnerPhone() {
        return cargoOwnerPhone;
    }

    public void setCargoOwnerPhone(String cargoOwnerPhone) {
        this.cargoOwnerPhone = cargoOwnerPhone;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoOwner that = (CargoOwner) o;

        if (cargoOwnerId != null ? !cargoOwnerId.equals(that.cargoOwnerId) : that.cargoOwnerId != null) return false;
        if (cargoOwnerName != null ? !cargoOwnerName.equals(that.cargoOwnerName) : that.cargoOwnerName != null)
            return false;
        if (cargoOwnerDesc != null ? !cargoOwnerDesc.equals(that.cargoOwnerDesc) : that.cargoOwnerDesc != null)
            return false;
        if (cargoOwnerPhone != null ? !cargoOwnerPhone.equals(that.cargoOwnerPhone) : that.cargoOwnerPhone != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cargoOwnerId != null ? cargoOwnerId.hashCode() : 0;
        result = 31 * result + (cargoOwnerName != null ? cargoOwnerName.hashCode() : 0);
        result = 31 * result + (cargoOwnerDesc != null ? cargoOwnerDesc.hashCode() : 0);
        result = 31 * result + (cargoOwnerPhone != null ? cargoOwnerPhone.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "cargoOwnerByCargoOwnerId")
    public Collection<Ticket> getTicketsByCargoOwnerId() {
        return ticketsByCargoOwnerId;
    }

    public void setTicketsByCargoOwnerId(Collection<Ticket> ticketsByCargoOwnerId) {
        this.ticketsByCargoOwnerId = ticketsByCargoOwnerId;
    }
}
