package com.scm.services.service;

import com.scm.services.model.Ticket;

import java.util.List;

public interface TicketService {
    void addTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    void removeTicket(int id);
    Ticket getTicketById(int id);
    List<Ticket> getAllTickets();
}
