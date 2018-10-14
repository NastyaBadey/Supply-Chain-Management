package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Waypoint {
    private Integer waypointId;
    private Integer routeId;
    private Integer rateId;
    private Integer fromLocalityId;
    private Integer toLacalityId;
    private Byte backward;
    private Collection<TransportationWaypoint> transportationWaypointsByWaypointId;
    private Route routeByRouteId;
    private Rate rateByRateId;
    private Locality localityByFromLocalityId;
    private Locality localityByToLacalityId;

    @Id
    @Column(name = "waypoint_id", nullable = false)
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
    @Column(name = "rate_id", nullable = true)
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
    @Column(name = "to_lacality_id", nullable = false)
    public Integer getToLacalityId() {
        return toLacalityId;
    }

    public void setToLacalityId(Integer toLacalityId) {
        this.toLacalityId = toLacalityId;
    }

    @Basic
    @Column(name = "backward", nullable = true)
    public Byte getBackward() {
        return backward;
    }

    public void setBackward(Byte backward) {
        this.backward = backward;
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
        if (toLacalityId != null ? !toLacalityId.equals(waypoint.toLacalityId) : waypoint.toLacalityId != null)
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
        result = 31 * result + (toLacalityId != null ? toLacalityId.hashCode() : 0);
        result = 31 * result + (backward != null ? backward.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "waypointByWaypointId")
    public Collection<TransportationWaypoint> getTransportationWaypointsByWaypointId() {
        return transportationWaypointsByWaypointId;
    }

    public void setTransportationWaypointsByWaypointId(Collection<TransportationWaypoint> transportationWaypointsByWaypointId) {
        this.transportationWaypointsByWaypointId = transportationWaypointsByWaypointId;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "route_id", nullable = false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "rate_id", referencedColumnName = "rate_id")
    public Rate getRateByRateId() {
        return rateByRateId;
    }

    public void setRateByRateId(Rate rateByRateId) {
        this.rateByRateId = rateByRateId;
    }

    @ManyToOne
    @JoinColumn(name = "from_locality_id", referencedColumnName = "locality_id", nullable = false)
    public Locality getLocalityByFromLocalityId() {
        return localityByFromLocalityId;
    }

    public void setLocalityByFromLocalityId(Locality localityByFromLocalityId) {
        this.localityByFromLocalityId = localityByFromLocalityId;
    }

    @ManyToOne
    @JoinColumn(name = "to_lacality_id", referencedColumnName = "locality_id", nullable = false)
    public Locality getLocalityByToLacalityId() {
        return localityByToLacalityId;
    }

    public void setLocalityByToLacalityId(Locality localityByToLacalityId) {
        this.localityByToLacalityId = localityByToLacalityId;
    }
}
