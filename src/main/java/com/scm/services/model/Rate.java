package com.scm.services.model;

import javax.persistence.*;

@Entity
public class Rate {
    private Integer rateId;
    private Double ratePricePerKg;
    private Double averageSpeed;
    private Integer carrierId;
    private Integer deliveryMethodId;

    @Id
    @Column(name = "rate_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "rate_price_per_kg", nullable = false, precision = 2)
    public Double getRatePricePerKg() {
        return ratePricePerKg;
    }

    public void setRatePricePerKg(Double rateCost) {
        this.ratePricePerKg = rateCost;
    }

    @Basic
    @Column(name = "average_speed", nullable = false, precision = 2)
    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Basic
    @Column(name = "carrier_id", nullable = false)
    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    @Basic
    @Column(name = "delivery_method_id", nullable = false)
    public Integer getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rateId=" + rateId +
                ", ratePricePerKg=" + ratePricePerKg +
                ", averageSpeed=" + averageSpeed +
                ", carrierId=" + carrierId +
                ", deliveryMethodId=" + deliveryMethodId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (rateId != null ? !rateId.equals(rate.rateId) : rate.rateId != null) return false;
        if (ratePricePerKg != null ? !ratePricePerKg.equals(rate.ratePricePerKg) : rate.ratePricePerKg != null)
            return false;
        if (averageSpeed != null ? !averageSpeed.equals(rate.averageSpeed) : rate.averageSpeed != null) return false;
        if (carrierId != null ? !carrierId.equals(rate.carrierId) : rate.carrierId != null) return false;
        return deliveryMethodId != null ? deliveryMethodId.equals(rate.deliveryMethodId) : rate.deliveryMethodId == null;
    }

    @Override
    public int hashCode() {
        int result = rateId != null ? rateId.hashCode() : 0;
        result = 31 * result + (ratePricePerKg != null ? ratePricePerKg.hashCode() : 0);
        result = 31 * result + (averageSpeed != null ? averageSpeed.hashCode() : 0);
        result = 31 * result + (carrierId != null ? carrierId.hashCode() : 0);
        result = 31 * result + (deliveryMethodId != null ? deliveryMethodId.hashCode() : 0);
        return result;
    }
}
