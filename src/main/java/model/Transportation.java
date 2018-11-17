package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Transportation {
    private Integer transportationId;
    private Integer ticketId;
    private Integer carrierId;
    private String status;
    private Timestamp destinationDate;
    private Double totalPrice;
    private Ticket ticketByTicketId;
    private Carrier carrierByCarrierId;
    private Collection<TransportationWaypoint> transportationWaypointsByTransportationId;

    @Id
    @Column(name = "transportation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
    }

    @Basic
    @Column(name = "ticket_id", nullable = false)
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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
    @Column(name = "status", nullable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "destination_date", nullable = false)
    public Timestamp getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Timestamp destinationDate) {
        this.destinationDate = destinationDate;
    }

    @Basic
    @Column(name = "total_price", nullable = false, precision = 2)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalCost) {
        this.totalPrice = totalCost;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id", nullable = false)
    public Ticket getTicketByTicketId() {
        return ticketByTicketId;
    }

    public void setTicketByTicketId(Ticket ticketByTicketId) {
        this.ticketByTicketId = ticketByTicketId;
    }

    @ManyToOne
    @JoinColumn(name = "carrier_id", referencedColumnName = "carrier_id", nullable = false)
    public Carrier getCarrierByCarrierId() {
        return carrierByCarrierId;
    }

    public void setCarrierByCarrierId(Carrier carrierByCarrierId) {
        this.carrierByCarrierId = carrierByCarrierId;
    }

    @OneToMany(mappedBy = "transportationByTransportationId")
    public Collection<TransportationWaypoint> getTransportationWaypointsByTransportationId() {
        return transportationWaypointsByTransportationId;
    }

    public void setTransportationWaypointsByTransportationId(Collection<TransportationWaypoint> transportationWaypointsByTransportationId) {
        this.transportationWaypointsByTransportationId = transportationWaypointsByTransportationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transportation that = (Transportation) o;

        if (transportationId != null ? !transportationId.equals(that.transportationId) : that.transportationId != null)
            return false;
        if (ticketId != null ? !ticketId.equals(that.ticketId) : that.ticketId != null) return false;
        if (carrierId != null ? !carrierId.equals(that.carrierId) : that.carrierId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (destinationDate != null ? !destinationDate.equals(that.destinationDate) : that.destinationDate != null)
            return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (ticketByTicketId != null ? !ticketByTicketId.equals(that.ticketByTicketId) : that.ticketByTicketId != null)
            return false;
        if (carrierByCarrierId != null ? !carrierByCarrierId.equals(that.carrierByCarrierId) : that.carrierByCarrierId != null)
            return false;
        return transportationWaypointsByTransportationId != null ? transportationWaypointsByTransportationId.equals(that.transportationWaypointsByTransportationId) : that.transportationWaypointsByTransportationId == null;
    }

    @Override
    public int hashCode() {
        int result = transportationId != null ? transportationId.hashCode() : 0;
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        result = 31 * result + (carrierId != null ? carrierId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (destinationDate != null ? destinationDate.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (ticketByTicketId != null ? ticketByTicketId.hashCode() : 0);
        result = 31 * result + (carrierByCarrierId != null ? carrierByCarrierId.hashCode() : 0);
        result = 31 * result + (transportationWaypointsByTransportationId != null ? transportationWaypointsByTransportationId.hashCode() : 0);
        return result;
    }
}
