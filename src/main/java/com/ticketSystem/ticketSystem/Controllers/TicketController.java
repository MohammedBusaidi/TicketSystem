package com.ticketSystem.ticketSystem.Controllers;

import com.ticketSystem.ticketSystem.Models.*;
import com.ticketSystem.ticketSystem.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Ticket> ticketManagement(
            @PathVariable("ticketId") Long ticketId,
            @RequestBody ManageTicketRequest manageTicketRequest) {
        Ticket ticket = ticketService.manageTickets(ticketId, manageTicketRequest);
        return ResponseEntity.ok(ticket);
    }
}
