package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Models.ManageTicketRequest;
import com.ticketSystem.ticketSystem.Models.Ticket;
import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Repositories.TicketRepository;
import com.ticketSystem.ticketSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;

    public Long createTicket(Ticket ticket){
        LocalDateTime now = LocalDateTime.now();
        ticket.setCreatedDate(now);
        ticket.setActive(true);
        ticketRepository.save(ticket);
        return ticket.getTicketId();
    }

    public Ticket findTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).get();
    }
    public Ticket assignTickets(Long ticketId, Long representativeId) {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        User user = userRepository.findById(representativeId).get();
        ticket.setUser(user);
        return ticketRepository.save(ticket);
    }
    public Ticket ticketManagement(Long ticketId, ManageTicketRequest manageTicketRequest){
        Ticket ticket = ticketRepository.findById(ticketId).get();
        ticket.setStatus(manageTicketRequest.status());
        ticket.setNotes(manageTicketRequest.notes());
        return ticketRepository.save(ticket);
    }
}
