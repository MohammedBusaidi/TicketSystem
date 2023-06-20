package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Enum.Priority;
import com.ticketSystem.ticketSystem.Enum.Status;
import com.ticketSystem.ticketSystem.Models.ManageTicketRequest;
import com.ticketSystem.ticketSystem.Models.Ticket;
import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Repositories.TicketRepository;
import com.ticketSystem.ticketSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;

    public Long createTicket(Ticket ticket) {
        LocalDateTime now = LocalDateTime.now();
        ticket.setCreatedDate(now);
        ticket.setActive(true);
        ticketRepository.save(ticket);
        return ticket.getTicketId();
    }

    public Ticket assignTickets(Long ticketId, Long representativeId) {
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket = ticketRepository.findById(ticketId).get();
        User user = userRepository.findById(representativeId).get();
        ticket.setUser(user);
        ticket.setUpdatedDate(now);
        return ticketRepository.save(ticket);
    }

    public Ticket manageTickets(Long ticketId, ManageTicketRequest manageTicketRequest) {
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket = ticketRepository.findById(ticketId).get();
        ticket.setStatus(manageTicketRequest.status());
        ticket.setNotes(manageTicketRequest.notes());
        ticket.setUpdatedDate(now);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByCriteria(Long ticketId, Priority priority, Status status) {
        if (ticketId != null) {
            Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
            if (ticket != null) {
                List<Ticket> ticketList = new ArrayList<>();
                ticketList.add(ticket);
                return ticketList;
            }
        } else if (status != null) {
            return ticketRepository.findByStatus(status);
        } else if (priority != null) {
            return ticketRepository.findByPriority(priority);
        }

        return Collections.emptyList();
    }
}
