package com.scm.services.util;

import com.scm.services.model.Ticket;
import com.scm.services.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketServiceUtil {
    private static TicketService ticketService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public static void addTicket(Ticket ticket){
        ticketService.addTicket(ticket);
    }

    public static void updateTicket(Ticket ticket){
        ticketService.updateTicket(ticket);
    }

    public static void removeTicket(int ticketId){
        ticketService.removeTicket(ticketId);
    }

    public static Ticket getTicketById(int ticketId){
        return ticketService.getTicketById(ticketId);
    }

    public static List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
