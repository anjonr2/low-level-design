package com.lld.jirasystem.observer;

import com.lld.jirasystem.model.Comment;
import com.lld.jirasystem.model.IssueType;
import com.lld.jirasystem.state.IssueState;
import com.lld.jirasystem.state.TodoState;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Issue in the Jira system.
 * It can be observed by multiple observers (e.g., users, teams)
 * who are interested in receiving updates about the issue's status, comments, or other changes.
 * The Issue class will have methods to manage its state and notify observers when changes occur.
 * Issue class is the observable entity in the Observer design pattern,
 * allowing observers to subscribe and receive updates when the issue's state changes.
 */
public class Issue {
    private final String id;
    private final String title;
    private final IssueType type;

    private User assignee;
    private IssueState issueState = new TodoState();

    private final List<Comment> comments = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public Issue(String id, String title, IssueType type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    private void notifyObservers(String message){
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void assign(User user){
        this.assignee = user;
        notifyObservers("Issue "+title + " moved to "+user.getName());
    }

    public void changeState(IssueState newState){
        this.issueState= newState;
        notifyObservers("Issue "+ title + " moved to "+newState.getStatus());
    }

    public void addComment(String comment){
        comments.add(new Comment(comment));
        notifyObservers("Commented on "+title);
    }

    public User getAssignee() {
        return assignee;
    }

    public String getStatus(){
        return issueState.getStatus();
    }

    public String getTitle() {
        return title;
    }
}
