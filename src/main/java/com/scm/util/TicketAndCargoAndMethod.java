package com.scm.util;

import com.scm.services.model.Cargo;
import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.Locality;
import com.scm.services.model.Ticket;

public class TicketAndCargoAndMethod {
    Ticket ticket;
    Cargo cargo;
    DeliveryMethod deliveryMethod;
    Locality locality;

    public TicketAndCargoAndMethod() {
        this.ticket = new Ticket();
        this.cargo = new Cargo();
        this.deliveryMethod = new DeliveryMethod();
        this.locality = new Locality();
    }

    public TicketAndCargoAndMethod(Ticket ticket, Cargo cargo, DeliveryMethod deliveryMethod) {
        this.ticket = ticket;
        this.cargo = cargo;
        this.deliveryMethod = deliveryMethod;
        this.locality=locality;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketAndCargoAndMethod that = (TicketAndCargoAndMethod) o;

        if (ticket != null ? !ticket.equals(that.ticket) : that.ticket != null) return false;
        if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
        if (deliveryMethod != null ? !deliveryMethod.equals(that.deliveryMethod) : that.deliveryMethod != null)
            return false;
        return locality != null ? locality.equals(that.locality) : that.locality == null;
    }

    @Override
    public int hashCode() {
        int result = ticket != null ? ticket.hashCode() : 0;
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketAndCargoAndMethod{" +
                "ticket=" + ticket +
                ", cargo=" + cargo +
                ", deliveryMethod=" + deliveryMethod +
                ", locality=" + locality +
                '}';
    }
}




