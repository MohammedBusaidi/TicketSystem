package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Models.Ticket;
import com.ticketSystem.ticketSystem.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
