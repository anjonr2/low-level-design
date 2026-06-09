package com.lld.jirasystem1.observer;

public interface TicketSubject {
    void registerObserver(TicketObserver observer);
    void removeObserver(TicketObserver observer);
    void notifyObservers(TicketEvent event);
}
