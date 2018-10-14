package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Rate {
    private Integer rateId;
    private Double rateCost;
    private Integer carrierId;
    private Carrier carrierByCarrierId;
    private Collection<RateDeliveryMethod> rateDeliveryMethodsByRateId;
    private Collection<Waypoint> waypointsByRateId;

    @Id
    @Column(name = "rate_id", nullable = false)
    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "rate_cost", nullable = false, precision = 2)
    public Double getRateCost() {
        return rateCost;
    }

    public void setRateCost(Double rateCost) {
        this.rateCost = rateCost;
    }

    @Basic
    @Column(name = "carrier_id", nullable = false)
    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (rateId != null ? !rateId.equals(rate.rateId) : rate.rateId != null) return false;
        if (rateCost != null ? !rateCost.equals(rate.rateCost) : rate.rateCost != null) return false;
        if (carrierId != null ? !carrierId.equals(rate.carrierId) : rate.carrierId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rateId != null ? rateId.hashCode() : 0;
        result = 31 * result + (rateCost != null ? rateCost.hashCode() : 0);
        result = 31 * result + (carrierId != null ? carrierId.hashCode() : 0);
        return result;
    }

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
}
