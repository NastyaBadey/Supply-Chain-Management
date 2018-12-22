package com.scm.services.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Waypoint {
    private Integer waypointId;
    private Integer routeId;
    private Integer rateId;
    private Integer fromLocalityId;
    private Integer toLocalityId;
    private Byte backward;

    @Id
    @Column(name = "waypoint_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(Integer waypointId) {
        this.waypointId = waypointId;
    }

    @Basic
    @Column(name = "route_id", nullable = false)
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "rate_id")
    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "from_locality_id", nullable = false)
    public Integer getFromLocalityId() {
        return fromLocalityId;
    }

    public void setFromLocalityId(Integer fromLocalityId) {
        this.fromLocalityId = fromLocalityId;
    }

    @Basic
    @Column(name = "to_locality_id", nullable = false)
    public Integer getToLocalityId() {
        return toLocalityId;
    }

    public void setToLocalityId(Integer toLocalityId) {
        this.toLocalityId = toLocalityId;
    }

    @Basic
    @Column(name = "backward")
    public Byte getBackward() {
        return backward;
    }

    public void setBackward(Byte backward) {
        this.backward = backward;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "waypointId=" + waypointId +
                ", routeId=" + routeId +
                ", rateId=" + rateId +
                ", fromLocalityId=" + fromLocalityId +
                ", toLocalityId=" + toLocalityId +
                ", backward=" + backward +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Waypoint waypoint = (Waypoint) o;

        if (waypointId != null ? !waypointId.equals(waypoint.waypointId) : waypoint.waypointId != null) return false;
        if (routeId != null ? !routeId.equals(waypoint.routeId) : waypoint.routeId != null) return false;
        if (rateId != null ? !rateId.equals(waypoint.rateId) : waypoint.rateId != null) return false;
        if (fromLocalityId != null ? !fromLocalityId.equals(waypoint.fromLocalityId) : waypoint.fromLocalityId != null)
            return false;
        if (toLocalityId != null ? !toLocalityId.equals(waypoint.toLocalityId) : waypoint.toLocalityId != null)
            return false;
        if (backward != null ? !backward.equals(waypoint.backward) : waypoint.backward != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = waypointId != null ? waypointId.hashCode() : 0;
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (rateId != null ? rateId.hashCode() : 0);
        result = 31 * result + (fromLocalityId != null ? fromLocalityId.hashCode() : 0);
        result = 31 * result + (toLocalityId != null ? toLocalityId.hashCode() : 0);
        result = 31 * result + (backward != null ? backward.hashCode() : 0);
        return result;
    }
}
