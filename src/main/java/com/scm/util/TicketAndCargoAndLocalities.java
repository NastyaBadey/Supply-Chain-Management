package com.scm.util;

import com.scm.services.model.Cargo;
import com.scm.services.model.Locality;
import com.scm.services.model.Ticket;

public class TicketAndCargoAndLocalities {
    Ticket ticket;
    Cargo cargo;
    Locality departureLocality;
    Locality destinationLocality;

    public TicketAndCargoAndLocalities() {
        this.ticket = new Ticket();
        this.cargo = new Cargo();
        this.departureLocality = new Locality();
        this.destinationLocality = new Locality();
    }

    public TicketAndCargoAndLocalities(Ticket ticket, Cargo cargo, Locality departureLocality, Locality destinationLocality) {
        this.ticket = ticket;
        this.cargo = cargo;
        this.departureLocality = departureLocality;
        this.destinationLocality = destinationLocality;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Locality getDepartureLocality() {
        return departureLocality;
    }

    public void setDepartureLocality(Locality departureLocality) {
        this.departureLocality = departureLocality;
    }

    public Locality getDestinationLocality() {
        return destinationLocality;
    }

    public void setDestinationLocality(Locality destinationLocality) {
        this.destinationLocality = destinationLocality;
    }

    @Override
    public String toString() {
        return "TicketAndCargoAndMethod{" +
                "ticket=" + ticket +
                ", cargo=" + cargo +
                ", departureLocality=" + departureLocality +
                ", destinationLocality=" + destinationLocality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketAndCargoAndLocalities that = (TicketAndCargoAndLocalities) o;

        if (ticket != null ? !ticket.equals(that.ticket) : that.ticket != null) return false;
        if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
        if (departureLocality != null ? !departureLocality.equals(that.departureLocality) : that.departureLocality != null)
            return false;
        return destinationLocality != null ? destinationLocality.equals(that.destinationLocality) : that.destinationLocality == null;
    }

    @Override
    public int hashCode() {
        int result = ticket != null ? ticket.hashCode() : 0;
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (departureLocality != null ? departureLocality.hashCode() : 0);
        result = 31 * result + (destinationLocality != null ? destinationLocality.hashCode() : 0);
        return result;
    }
}




