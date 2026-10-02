package com.lld.behavioral.iterator.notificationsystem;

public class NotificationAppDemo {
    public static void main(String[] args){
        NotificationCenter center = new NotificationCenter();
        center.add(new Notification("Your order shipped", "EMAIL"));
        center.add(new Notification("Flash sale today", "PUSH"));
        center.add(new Notification("Verify your number", "SMS"));
        center.add(new Notification("Invoice ready", "EMAIL"));
        center.add(new Notification("New login detected", "PUSH"));

        //mark some as read
        center.getAt(0).markRead();
        center.getAt(2).markRead();

        System.out.println("--- All notifications ---");
        NotificationIterator all = center.createIterator();

        while (all.hasNext()){
            System.out.println(all.next());
        }

        System.out.println("--- EMAIL only ---");
        NotificationIterator emails = center.createFilteredIterator("EMAIL");
        while (emails.hasNext()){
            System.out.println(" "+ emails.next());
        }

        System.out.println("--- Unread only ---");
        NotificationIterator unread = center.createUnreadIterator();
        while (unread.hasNext()){
            System.out.println(" "+ unread.next());
        }
    }
}
