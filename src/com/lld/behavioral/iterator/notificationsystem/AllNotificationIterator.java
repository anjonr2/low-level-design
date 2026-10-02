package com.lld.behavioral.iterator.notificationsystem;

public class AllNotificationIterator implements NotificationIterator{
    private final NotificationCenter notificationCenter;
    private int index = 0;

    public AllNotificationIterator(NotificationCenter notificationCenter){
        this.notificationCenter = notificationCenter;
    }

    @Override
    public boolean hasNext() {
        return index< notificationCenter.getSize();
    }

    @Override
    public Notification next() {
        return notificationCenter.getAt(index++);
    }
}
