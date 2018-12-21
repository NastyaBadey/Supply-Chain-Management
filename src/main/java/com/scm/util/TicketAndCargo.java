package com.scm.util;

import com.scm.services.model.Cargo;
import com.scm.services.model.Ticket;

public class TicketAndCargo {
    Ticket ticket;
    Cargo cargo;

    public TicketAndCargo() {
        this.ticket = new Ticket();
        this.cargo = new Cargo();
    }

    public TicketAndCargo(Ticket ticket, Cargo cargo) {
        this.ticket = ticket;
        this.cargo = cargo;
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

    @Override
    public String toString() {
        return "TicketAndCargo{" +
                "ticket=" + ticket +
                ", cargo=" + cargo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketAndCargo that = (TicketAndCargo) o;

        if (ticket != null ? !ticket.equals(that.ticket) : that.ticket != null) return false;
        return cargo != null ? cargo.equals(that.cargo) : that.cargo == null;
    }

    @Override
    public int hashCode() {
        int result = ticket != null ? ticket.hashCode() : 0;
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        return result;
    }
}



