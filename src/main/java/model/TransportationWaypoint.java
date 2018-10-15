package model;

import javax.persistence.*;

@Entity
@Table(name = "transportation_waypoint", schema = "scm")
public class TransportationWaypoint {
    private Integer transportationWaypointId;
    private Integer transportationId;
    private Integer waypointId;
    private Transportation transportationByTransportationId;
    private Waypoint waypointByWaypointId;

    @Id
    @Column(name = "transportation_waypoint_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTransportationWaypointId() {
        return transportationWaypointId;
    }

    public void setTransportationWaypointId(Integer transportationWaypointId) {
        this.transportationWaypointId = transportationWaypointId;
    }

    @Basic
    @Column(name = "transportation_id", nullable = false)
    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
    }

    @Basic
    @Column(name = "waypoint_id", nullable = false)
    public Integer getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(Integer waypointId) {
        this.waypointId = waypointId;
    }

    @ManyToOne
    @JoinColumn(name = "transportation_id", referencedColumnName = "transportation_id", nullable = false)
    public Transportation getTransportationByTransportationId() {
        return transportationByTransportationId;
    }

    public void setTransportationByTransportationId(Transportation transportationByTransportationId) {
        this.transportationByTransportationId = transportationByTransportationId;
    }

    @ManyToOne
    @JoinColumn(name = "waypoint_id", referencedColumnName = "waypoint_id", nullable = false)
    public Waypoint getWaypointByWaypointId() {
        return waypointByWaypointId;
    }

    public void setWaypointByWaypointId(Waypoint waypointByWaypointId) {
        this.waypointByWaypointId = waypointByWaypointId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportationWaypoint that = (TransportationWaypoint) o;

        if (transportationWaypointId != null ? !transportationWaypointId.equals(that.transportationWaypointId) : that.transportationWaypointId != null)
            return false;
        if (transportationId != null ? !transportationId.equals(that.transportationId) : that.transportationId != null)
            return false;
        if (waypointId != null ? !waypointId.equals(that.waypointId) : that.waypointId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transportationWaypointId != null ? transportationWaypointId.hashCode() : 0;
        result = 31 * result + (transportationId != null ? transportationId.hashCode() : 0);
        result = 31 * result + (waypointId != null ? waypointId.hashCode() : 0);
        return result;
    }
}
