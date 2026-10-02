package com.lld.behavioral.iterator.notificationsystem;

public class FilteredIterator implements NotificationIterator{
    private final NotificationCenter notificationCenter;
    private final String type;
    private int index = 0;

    public FilteredIterator(NotificationCenter notificationCenter, String type) {
        this.notificationCenter = notificationCenter;
        this.type = type;
        advanceToNext();
    }

    private void advanceToNext(){
        while (index < notificationCenter.getSize()
                && !notificationCenter.getAt(index).getType().equals(type)){
            index+=1;
        }
    }

    @Override
    public boolean hasNext() {
        return index < notificationCenter.getSize();
    }

    @Override
    public Notification next() {
        Notification notification = notificationCenter.getAt(index);
        index++;
        advanceToNext();
        return notification;
    }
}
