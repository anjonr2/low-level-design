package com.lld.jirasystem1.state;

import com.lld.jirasystem1.observer.Ticket;
import com.lld.jirasystem1.observer.User;

public interface TicketState {
    boolean backlog(Ticket ticket, User user);
    boolean inProgress(Ticket ticket, User user);
    boolean devComplete(Ticket ticket, User user);
    boolean readyForReview(Ticket ticket, User user);
    boolean done(Ticket ticket, User user);
}
