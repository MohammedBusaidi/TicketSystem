package com.ticketSystem.ticketSystem.Repositories;

import com.ticketSystem.ticketSystem.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
