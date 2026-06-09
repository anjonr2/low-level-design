package com.lld.jirasystem1.state;

import com.lld.jirasystem1.model.TicketEventType;
import com.lld.jirasystem1.observer.Ticket;
import com.lld.jirasystem1.observer.TicketEvent;
import com.lld.jirasystem1.observer.User;

import java.util.HashSet;
import java.util.Set;

public class AbstractTicketState implements TicketState{
    protected final String stateName; //internal name for logging
    protected final Set<Class<? extends TicketState>> allowedBacklogFrom = new HashSet<>();
    protected final Set<Class<? extends TicketState>> allowedInProgressFrom = new HashSet<>();
    protected final Set<Class<? extends TicketState>> allowedDevCompleteFrom = new HashSet<>();
    protected final Set<Class<? extends TicketState>> allowedReadForReviewFrom = new HashSet<>();
    protected final Set<Class<? extends TicketState>> allowedDoneFrom = new HashSet<>();

    public AbstractTicketState(String stateName){
        this.stateName=stateName;
    }

    protected boolean tryTransition(Ticket ticket, TicketState newState, Set<Class<? extends TicketState>> allowedFrom, String actionName){
        if (!allowedFrom.contains(this.getClass())){
            return false;
        }
        TicketState oldState = ticket.getCurrentState();

        ticket.setCurrentState(newState);
        ticket.notifyObservers(new TicketEvent(ticket, TicketEventType.STATE_CHANGED, String.format("%s: %s -> %s", actionName, ((AbstractTicketState)oldState).stateName, ((AbstractTicketState)newState).stateName)));
        return true;

    }
    @Override
    public boolean backlog(Ticket ticket, User user) {
        return false;
    }

    @Override
    public boolean inProgress(Ticket ticket, User user) {
        return false;
    }

    @Override
    public boolean devComplete(Ticket ticket, User user) {
        return false;
    }

    @Override
    public boolean readyForReview(Ticket ticket, User user) {
        return false;
    }

    @Override
    public boolean done(Ticket ticket, User user) {
        return false;
    }
}
