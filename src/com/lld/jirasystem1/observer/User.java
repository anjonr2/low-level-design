package com.lld.jirasystem1.observer;

/*
 *  User - Represents a user in the system acts as an observer as well to receive ticket updates
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class User implements TicketObserver{
    private final String userId;
    private final String userName;
    private final String email;
    private final Set<Ticket> assignedTickets;
    private final List<String> notifications;

    public User(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.assignedTickets = ConcurrentHashMap.newKeySet();
        this.notifications = Collections.synchronizedList(new ArrayList<>());
    }

    public void assignTicket(Ticket ticket){
        assignedTickets.add(ticket);
        /*
            * Register this user as an observer to this ticket
            * so that they can receive updates about the ticket's status, comments, etc.
         */
        ticket.registerObserver(this);
    }

    public void unassignTicket(Ticket ticket){
        assignedTickets.remove(ticket);
        /*
            * Unregister this user as an observer from this ticket
            * so that they will no longer receive updates about the ticket's status, comments, etc.
         */
        ticket.removeObserver(this);
    }

    @Override
    public void update(TicketEvent event) {
        String notification = String.format("[User %s] Received update for ticket %s : %s", userName,event.getTicket().getId(), event.getMessage());
        notifications.add(notification);
        System.out.println(notification);
    }

    public List<String> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Ticket> getAssignedTickets() {
        return Collections.unmodifiableSet(assignedTickets);
    }
}
