package model;

import javax.persistence.*;

@Entity
@Table(name = "rate_delivery_method", schema = "scm")
public class RateDeliveryMethod {
    private Integer rateDeliveryMethodId;
    private Integer rateId;
    private Integer deliveryMethodId;
    private Rate rateByRateId;
    private DeliveryMethod deliveryMethodByDeliveryMethodId;

    @Id
    @Column(name = "rate_delivery_method_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRateDeliveryMethodId() {
        return rateDeliveryMethodId;
    }

    public void setRateDeliveryMethodId(Integer rateDeliveryMethodId) {
        this.rateDeliveryMethodId = rateDeliveryMethodId;
    }

    @Basic
    @Column(name = "rate_id", nullable = false)
    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "delivery_method_id", nullable = false)
    public Integer getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    @ManyToOne
    @JoinColumn(name = "rate_id", referencedColumnName = "rate_id", nullable = false)
    public Rate getRateByRateId() {
        return rateByRateId;
    }

    public void setRateByRateId(Rate rateByRateId) {
        this.rateByRateId = rateByRateId;
    }

    @ManyToOne
    @JoinColumn(name = "delivery_method_id", referencedColumnName = "delivery_method_id", nullable = false)
    public DeliveryMethod getDeliveryMethodByDeliveryMethodId() {
        return deliveryMethodByDeliveryMethodId;
    }

    public void setDeliveryMethodByDeliveryMethodId(DeliveryMethod deliveryMethodByDeliveryMethodId) {
        this.deliveryMethodByDeliveryMethodId = deliveryMethodByDeliveryMethodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RateDeliveryMethod that = (RateDeliveryMethod) o;

        if (rateDeliveryMethodId != null ? !rateDeliveryMethodId.equals(that.rateDeliveryMethodId) : that.rateDeliveryMethodId != null)
            return false;
        if (rateId != null ? !rateId.equals(that.rateId) : that.rateId != null) return false;
        if (deliveryMethodId != null ? !deliveryMethodId.equals(that.deliveryMethodId) : that.deliveryMethodId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rateDeliveryMethodId != null ? rateDeliveryMethodId.hashCode() : 0;
        result = 31 * result + (rateId != null ? rateId.hashCode() : 0);
        result = 31 * result + (deliveryMethodId != null ? deliveryMethodId.hashCode() : 0);
        return result;
    }
}
