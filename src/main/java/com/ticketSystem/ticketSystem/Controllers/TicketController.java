package com.ticketSystem.ticketSystem.Controllers;

import com.ticketSystem.ticketSystem.Enum.Priority;
import com.ticketSystem.ticketSystem.Enum.Status;
import com.ticketSystem.ticketSystem.Models.*;
import com.ticketSystem.ticketSystem.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/tickets")
public class TicketController extends GenericController {

    @Autowired
    TicketService ticketService;

    @PostMapping
    public ResponseEntity<APICustomResponse> createTicket(@RequestBody Ticket ticket) {
        Long ticketId = ticketService.createTicket(ticket);
        return createResponse(
                Map.of("ticketId", ticketId),
                "Ticket created successfully",
                CREATED);
    }

    @PutMapping("{ticketId}/assign")
    public ResponseEntity<APICustomResponse> assignTicketToUser(
            @PathVariable("ticketId") Long ticketId,
            @RequestBody AssignTicketRequest assignTicketRequest) {
        ticketService.assignTickets(ticketId, assignTicketRequest.representativeId());
        return createResponse(
                Map.of("representativeId", assignTicketRequest.representativeId()),
                "Ticket assigned successfully",
                OK);
    }

    @PutMapping("{ticketId}")
    public ResponseEntity<APICustomResponse> ticketManagement(
            @PathVariable("ticketId") Long ticketId,
            @RequestBody ManageTicketRequest manageTicketRequest) {
        Ticket ticket = ticketService.manageTickets(ticketId, manageTicketRequest);
        return createResponse(
                null,
                "Updated",
                OK);
    }

    @GetMapping
    public ResponseEntity<APICustomResponse> getTicketsByCriteria(
            @RequestParam(value = "id", required = false) Long ticketId,
            @RequestParam(value = "priority", required = false) Priority priority,
            @RequestParam(value = "status", required = false) Status status
    ) {
        List<Ticket> tickets = ticketService.getTicketsByCriteria(ticketId, priority, status);
            return createResponse(
                    Map.of("tickets", tickets),
                    "List of the searched tickets",
                    OK);

    }

}
