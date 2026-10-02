package com.lld.behavioral.iterator.notificationsystem;

public class UnreadIterator  implements NotificationIterator{
    private final NotificationCenter center;
    private int index = 0;

    public UnreadIterator(NotificationCenter center) {
        this.center = center;
        advanceToNextUnread();
    }

    private void advanceToNextUnread(){
        while (index < center.getSize() && center.getAt(index).isRead()){
            index++;
        }
    }
    @Override
    public boolean hasNext() {
        return index < center.getSize();
    }

    @Override
    public Notification next() {
        Notification notification = center.getAt(index);
        index++;
        advanceToNextUnread();
        return notification;
    }
}
