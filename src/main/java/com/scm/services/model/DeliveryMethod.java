package com.scm.services.model;

import javax.persistence.*;

@Entity
@Table(name = "delivery_method", schema = "scm")
public class DeliveryMethod {
    private Integer deliveryMethodId;
    private String deliveryMethodName;
    private String deliveryMethodDesc;

    @Id
    @Column(name = "delivery_method_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    @Basic
    @Column(name = "delivery_method_name", nullable = false, length = 40)
    public String getDeliveryMethodName() {
        return deliveryMethodName;
    }

    public void setDeliveryMethodName(String deliveryMethodName) {
        this.deliveryMethodName = deliveryMethodName;
    }

    @Basic
    @Column(name = "delivery_method_desc", length = 255)
    public String getDeliveryMethodDesc() {
        return deliveryMethodDesc;
    }

    public void setDeliveryMethodDesc(String deliveryMethodDesc) {
        this.deliveryMethodDesc = deliveryMethodDesc;
    }

    @Override
    public String toString() {
        return "DeliveryMethod{" +
                "deliveryMethodId=" + deliveryMethodId +
                ", deliveryMethodName='" + deliveryMethodName + '\'' +
                ", deliveryMethodDesc='" + deliveryMethodDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryMethod that = (DeliveryMethod) o;

        if (deliveryMethodId != null ? !deliveryMethodId.equals(that.deliveryMethodId) : that.deliveryMethodId != null)
            return false;
        if (deliveryMethodName != null ? !deliveryMethodName.equals(that.deliveryMethodName) : that.deliveryMethodName != null)
            return false;
        if (deliveryMethodDesc != null ? !deliveryMethodDesc.equals(that.deliveryMethodDesc) : that.deliveryMethodDesc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryMethodId != null ? deliveryMethodId.hashCode() : 0;
        result = 31 * result + (deliveryMethodName != null ? deliveryMethodName.hashCode() : 0);
        result = 31 * result + (deliveryMethodDesc != null ? deliveryMethodDesc.hashCode() : 0);
        return result;
    }
}
