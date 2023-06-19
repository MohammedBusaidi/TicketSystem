package com.ticketSystem.ticketSystem.Services;

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

//    public void assignTicketToUser(Long ticketId, Long userId) {
//        User user = userRepository.getOne(userId); // Get a reference to the user entity
//
//        Ticket ticket = ticketRepository.getOne(ticketId); // Get a reference to the ticket entity
//        ticket.assignUser(user); // Assign the ticket to the user
//        ticketRepository.save(ticket); // Save the updated ticket
//    }
}
