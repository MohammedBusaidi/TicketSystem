package com.ticketSystem.ticketSystem.Repositories;

import com.ticketSystem.ticketSystem.Enum.Priority;
import com.ticketSystem.ticketSystem.Enum.Status;
import com.ticketSystem.ticketSystem.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(Status status);
    List<Ticket> findByPriority(Priority priority);
}
