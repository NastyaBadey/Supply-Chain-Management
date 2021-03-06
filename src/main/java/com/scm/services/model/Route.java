package com.scm.services.model;

import javax.persistence.*;

@Entity
public class Route {
    private Integer routeId;
    private Integer departureLocalityId;
    private Integer destinationLocalityId;

    @Id
    @Column(name = "route_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "departure_locality_id", nullable = false)
    public Integer getDepartureLocalityId() {
        return departureLocalityId;
    }

    public void setDepartureLocalityId(Integer departureLocalityId) {
        this.departureLocalityId = departureLocalityId;
    }

    @Basic
    @Column(name = "destination_locality_id", nullable = false)
    public Integer getDestinationLocalityId() {
        return destinationLocalityId;
    }

    public void setDestinationLocalityId(Integer destinationLocalityId) {
        this.destinationLocalityId = destinationLocalityId;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", departureLocalityId=" + departureLocalityId +
                ", destinationLocalityId=" + destinationLocalityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != null ? !routeId.equals(route.routeId) : route.routeId != null) return false;
        if (departureLocalityId != null ? !departureLocalityId.equals(route.departureLocalityId) : route.departureLocalityId != null)
            return false;
        if (destinationLocalityId != null ? !destinationLocalityId.equals(route.destinationLocalityId) : route.destinationLocalityId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId != null ? routeId.hashCode() : 0;
        result = 31 * result + (departureLocalityId != null ? departureLocalityId.hashCode() : 0);
        result = 31 * result + (destinationLocalityId != null ? destinationLocalityId.hashCode() : 0);
        return result;
    }
}
