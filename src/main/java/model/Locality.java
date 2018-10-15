package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Locality {
    private Integer localityId;
    private String localityName;
    private String country;
    private Collection<Route> routesByLocalityId;
    private Collection<Route> routesByLocalityId_0;
    private Collection<Waypoint> waypointsByLocalityId;
    private Collection<Waypoint> waypointsByLocalityId_0;

    @Id
    @Column(name = "locality_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Integer localityId) {
        this.localityId = localityId;
    }

    @Basic
    @Column(name = "locality_name", nullable = false, length = 50)
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 30)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "localityByDepartureLocalityId")
    public Collection<Route> getRoutesByLocalityId() {
        return routesByLocalityId;
    }

    public void setRoutesByLocalityId(Collection<Route> routesByLocalityId) {
        this.routesByLocalityId = routesByLocalityId;
    }

    @OneToMany(mappedBy = "localityByDestinationLocalityId")
    public Collection<Route> getRoutesByLocalityId_0() {
        return routesByLocalityId_0;
    }

    public void setRoutesByLocalityId_0(Collection<Route> routesByLocalityId_0) {
        this.routesByLocalityId_0 = routesByLocalityId_0;
    }

    @OneToMany(mappedBy = "localityByFromLocalityId")
    public Collection<Waypoint> getWaypointsByLocalityId() {
        return waypointsByLocalityId;
    }

    public void setWaypointsByLocalityId(Collection<Waypoint> waypointsByLocalityId) {
        this.waypointsByLocalityId = waypointsByLocalityId;
    }

    @OneToMany(mappedBy = "localityByToLocalityId")
    public Collection<Waypoint> getWaypointsByLocalityId_0() {
        return waypointsByLocalityId_0;
    }

    public void setWaypointsByLocalityId_0(Collection<Waypoint> waypointsByLocalityId_0) {
        this.waypointsByLocalityId_0 = waypointsByLocalityId_0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locality locality = (Locality) o;

        if (localityId != null ? !localityId.equals(locality.localityId) : locality.localityId != null) return false;
        if (localityName != null ? !localityName.equals(locality.localityName) : locality.localityName != null)
            return false;
        if (country != null ? !country.equals(locality.country) : locality.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localityId != null ? localityId.hashCode() : 0;
        result = 31 * result + (localityName != null ? localityName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
