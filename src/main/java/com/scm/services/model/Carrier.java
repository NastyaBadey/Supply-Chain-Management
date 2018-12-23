package com.scm.services.model;

import javax.persistence.*;

@Entity
public class Carrier {
    private Integer carrierId;
    private String carrierName;
    private String carrierDesc;
    private String carrierPhone;
    private Integer userId;

    @Id
    @Column(name = "carrier_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    @Basic
    @Column(name = "carrier_name", nullable = false, length = 60)
    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    @Basic
    @Column(name = "carrier_desc", length = 255)
    public String getCarrierDesc() {
        return carrierDesc;
    }

    public void setCarrierDesc(String carrierDesc) {
        this.carrierDesc = carrierDesc;
    }

    @Basic
    @Column(name = "carrier_phone", length = 20)
    public String getCarrierPhone() {
        return carrierPhone;
    }

    public void setCarrierPhone(String carrierPhone) {
        this.carrierPhone = carrierPhone;
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
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", carrierDesc='" + carrierDesc + '\'' +
                ", carrierPhone='" + carrierPhone + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrier carrier = (Carrier) o;

        if (carrierId != null ? !carrierId.equals(carrier.carrierId) : carrier.carrierId != null) return false;
        if (carrierName != null ? !carrierName.equals(carrier.carrierName) : carrier.carrierName != null) return false;
        if (carrierDesc != null ? !carrierDesc.equals(carrier.carrierDesc) : carrier.carrierDesc != null) return false;
        if (carrierPhone != null ? !carrierPhone.equals(carrier.carrierPhone) : carrier.carrierPhone != null)
            return false;
        if (userId != null ? !userId.equals(carrier.userId) : carrier.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carrierId != null ? carrierId.hashCode() : 0;
        result = 31 * result + (carrierName != null ? carrierName.hashCode() : 0);
        result = 31 * result + (carrierDesc != null ? carrierDesc.hashCode() : 0);
        result = 31 * result + (carrierPhone != null ? carrierPhone.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
