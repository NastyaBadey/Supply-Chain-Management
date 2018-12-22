package com.scm.services.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Ticket {
    private Integer ticketId;
    private Integer cargoOwnerId;
    private Integer cargoId;
    private Integer cargoQuantity;
    private Timestamp departureDate;
    private Integer routeId;
    private String status;
    private Timestamp dateOfCreation;

    @Id
    @Column(name = "ticket_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "cargo_owner_id", nullable = false)
    public Integer getCargoOwnerId() {
        return cargoOwnerId;
    }

    public void setCargoOwnerId(Integer cargoOwnerId) {
        this.cargoOwnerId = cargoOwnerId;
    }

    @Basic
    @Column(name = "cargo_id", nullable = false)
    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Basic
    @Column(name = "cargo_quantity", nullable = false)
    public Integer getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(Integer cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    @Basic
    @Column(name = "departure_date", nullable = false)
    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
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
    @Column(name = "status", length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_of_creation", nullable = false)
    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", cargoOwnerId=" + cargoOwnerId +
                ", cargoId=" + cargoId +
                ", cargoQuantity=" + cargoQuantity +
                ", departureDate=" + departureDate +
                ", routeId=" + routeId +
                ", status='" + status + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != null ? !ticketId.equals(ticket.ticketId) : ticket.ticketId != null) return false;
        if (cargoOwnerId != null ? !cargoOwnerId.equals(ticket.cargoOwnerId) : ticket.cargoOwnerId != null)
            return false;
        if (cargoId != null ? !cargoId.equals(ticket.cargoId) : ticket.cargoId != null) return false;
        if (cargoQuantity != null ? !cargoQuantity.equals(ticket.cargoQuantity) : ticket.cargoQuantity != null)
            return false;
        if (departureDate != null ? !departureDate.equals(ticket.departureDate) : ticket.departureDate != null)
            return false;
        if (routeId != null ? !routeId.equals(ticket.routeId) : ticket.routeId != null) return false;
        if (status != null ? !status.equals(ticket.status) : ticket.status != null) return false;
        return dateOfCreation != null ? dateOfCreation.equals(ticket.dateOfCreation) : ticket.dateOfCreation == null;
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (cargoOwnerId != null ? cargoOwnerId.hashCode() : 0);
        result = 31 * result + (cargoId != null ? cargoId.hashCode() : 0);
        result = 31 * result + (cargoQuantity != null ? cargoQuantity.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        return result;
    }
}
