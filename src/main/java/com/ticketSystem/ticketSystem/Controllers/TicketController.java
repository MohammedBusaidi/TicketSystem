package com.ticketSystem.ticketSystem.Controllers;

import com.ticketSystem.ticketSystem.Models.APICustomResponse;
import com.ticketSystem.ticketSystem.Models.Ticket;
import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Services.TicketService;
import com.ticketSystem.ticketSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @PutMapping("/{ticketId}/assign")
//    public ResponseEntity<APICustomResponse> updateTicket(@PathVariable Long ticketId, @RequestBody User user) {
//        ticketService.assignTicketToUser(ticketId, user.getUserId());
//        return createResponse(null,
//                "representativeId: " + user.getUserId(),
//                OK);
//    }
}
