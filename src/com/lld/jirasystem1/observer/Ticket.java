package com.lld.jirasystem1.observer;

import com.lld.jirasystem1.model.Comment;
import com.lld.jirasystem1.model.Priority;
import com.lld.jirasystem1.model.TicketType;
import com.lld.jirasystem1.state.TicketState;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket implements TicketSubject{
    private final String id;
    private final String title;
    private String description;
    private TicketType type;
    private Priority priority;
    private final User reporter;
    private User assignee;
    private TicketState currentState;
    private final List<Comment> comments = Collections.synchronizedList(new ArrayList<>());
    private final List<TicketObserver> observers = Collections.synchronizedList(new ArrayList<>());
    private final Instant createdAt = Instant.now();
    private final Instant updatedAt = Instant.now();

    public Ticket(String id, String title, User reporter) {
        this.id = id;
        this.title = title;
        this.reporter = reporter;
    }

    public void setCurrentState(TicketState newState){
        this.currentState=newState;
    }

    void setAssignee(User user){
        this.assignee=user;
    }

    @Override
    public void registerObserver(TicketObserver observer) {

    }

    @Override
    public void removeObserver(TicketObserver observer) {

    }

    @Override
    public void notifyObservers(TicketEvent event) {

    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public TicketState getCurrentState() {
        return currentState;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getReporter() {
        return reporter;
    }

    public Priority getPriority() {
        return priority;
    }

    public TicketType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
