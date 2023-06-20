package com.ticketSystem.ticketSystem.Models;

import com.ticketSystem.ticketSystem.Enum.Status;

public record ManageTicketRequest(
        Status status ,
        String notes
) {
}
