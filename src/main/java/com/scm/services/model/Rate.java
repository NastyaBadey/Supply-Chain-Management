package com.scm.services.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Rate {
    private Integer rateId;
    private Double ratePricePerKg;
    private Double averageSpeed;
    private Integer carrierId;
    private Carrier carrierByCarrierId;
    private Collection<RateDeliveryMethod> rateDeliveryMethodsByRateId;
    private Collection<Waypoint> waypointsByRateId;

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
    /*
    @Basic
    @Column(name = "carrier_id", nullable = false)
    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }*/

    @ManyToOne
    @JoinColumn(name = "carrier_id", referencedColumnName = "carrier_id", nullable = false)
    public Carrier getCarrierByCarrierId() {
        return carrierByCarrierId;
    }

    public void setCarrierByCarrierId(Carrier carrierByCarrierId) {
        this.carrierByCarrierId = carrierByCarrierId;
    }

    @OneToMany(mappedBy = "rateByRateId")
    public Collection<RateDeliveryMethod> getRateDeliveryMethodsByRateId() {
        return rateDeliveryMethodsByRateId;
    }

    public void setRateDeliveryMethodsByRateId(Collection<RateDeliveryMethod> rateDeliveryMethodsByRateId) {
        this.rateDeliveryMethodsByRateId = rateDeliveryMethodsByRateId;
    }

    @OneToMany(mappedBy = "rateByRateId")
    public Collection<Waypoint> getWaypointsByRateId() {
        return waypointsByRateId;
    }

    public void setWaypointsByRateId(Collection<Waypoint> waypointsByRateId) {
        this.waypointsByRateId = waypointsByRateId;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rateId=" + rateId +
                ", ratePricePerKg=" + ratePricePerKg +
                ", averageSpeed=" + averageSpeed +
                ", carrierId=" + carrierId +
                ", carrierByCarrierId=" + carrierByCarrierId +
                ", rateDeliveryMethodsByRateId=" + rateDeliveryMethodsByRateId +
                ", waypointsByRateId=" + waypointsByRateId +
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
        if (carrierByCarrierId != null ? !carrierByCarrierId.equals(rate.carrierByCarrierId) : rate.carrierByCarrierId != null)
            return false;
        if (rateDeliveryMethodsByRateId != null ? !rateDeliveryMethodsByRateId.equals(rate.rateDeliveryMethodsByRateId) : rate.rateDeliveryMethodsByRateId != null)
            return false;
        return waypointsByRateId != null ? waypointsByRateId.equals(rate.waypointsByRateId) : rate.waypointsByRateId == null;
    }

    @Override
    public int hashCode() {
        int result = rateId != null ? rateId.hashCode() : 0;
        result = 31 * result + (ratePricePerKg != null ? ratePricePerKg.hashCode() : 0);
        result = 31 * result + (averageSpeed != null ? averageSpeed.hashCode() : 0);
        result = 31 * result + (carrierId != null ? carrierId.hashCode() : 0);
        result = 31 * result + (carrierByCarrierId != null ? carrierByCarrierId.hashCode() : 0);
        result = 31 * result + (rateDeliveryMethodsByRateId != null ? rateDeliveryMethodsByRateId.hashCode() : 0);
        result = 31 * result + (waypointsByRateId != null ? waypointsByRateId.hashCode() : 0);
        return result;
    }
}
