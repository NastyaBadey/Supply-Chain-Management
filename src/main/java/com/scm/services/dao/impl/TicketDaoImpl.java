package com.scm.services.dao.impl;

import com.scm.services.dao.TicketDao;
import com.scm.services.model.Ticket;
import com.scm.util.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {
    private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public Ticket add(Ticket ticket) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ticket);
        Constants.showMessage("Ticket successfully added. Ticket details: " + ticket);
        return ticket;
    }

    public void update(Ticket ticket) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ticket);
        Constants.showMessage("Ticket successfully updated. Ticket details: " + ticket);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ticket ticket = session.load(Ticket.class, id);
        if (ticket != null) {
            session.delete(ticket);
            Constants.showMessage("Ticket successfully removed. Ticket details: " + ticket);
            return;
        }
        Constants.showErrorMessage("Ticket with id \'" + id + "\' cannot be removed.");
    }

    public Ticket getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ticket ticket = session.load(Ticket.class, id);
        Constants.showMessage("Ticket successfully loaded. Ticket details: " + ticket);
        return ticket;
    }

    public List<Ticket> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Ticket> ticketList = session.createQuery("from Ticket").list();
        for (Ticket ticket : ticketList) {
            Constants.showMessage("Ticket list element: " + ticket);
        }
        return ticketList;
    }
}
