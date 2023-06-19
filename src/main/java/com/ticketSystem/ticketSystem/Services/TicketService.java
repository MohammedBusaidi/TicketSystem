package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Models.Ticket;
import com.ticketSystem.ticketSystem.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket){
        LocalDateTime now = LocalDateTime.now();
        ticket.setCreatedDate(now);
        ticket.setActive(true);
        return ticketRepository.save(ticket);
    }
}
