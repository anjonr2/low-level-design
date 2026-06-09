package com.lld.jirasystem1.observer;

import com.lld.jirasystem1.model.TicketEventType;

import java.time.Instant;

public class TicketEvent {
    private final Ticket ticket;
    private final TicketEventType eventType;
    private final String message;
    private final Instant timestamp;

    public TicketEvent(Ticket ticket, TicketEventType eventType, String message) {
        this.ticket = ticket;
        this.eventType = eventType;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public TicketEventType getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
