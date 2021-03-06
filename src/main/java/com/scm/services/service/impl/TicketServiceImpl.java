package com.scm.services.service.impl;

import com.scm.services.dao.TicketDao;
import com.scm.services.model.Ticket;
import com.scm.services.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Transactional
    public Ticket addTicket(Ticket ticket) {
        return ticketDao.add(ticket);
    }

    @Transactional
    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    @Transactional
    public void removeTicket(int ticketId) {
        ticketDao.remove(ticketId);
    }

    @Transactional
    public Ticket getTicketById(int ticketId) {
        return ticketDao.getById(ticketId);
    }

    @Transactional
    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    }
}
