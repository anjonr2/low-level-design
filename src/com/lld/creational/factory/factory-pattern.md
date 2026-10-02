**The problem : Sending notification**
__Imagine you're building a web application that sends notifications
to users. At first, it's simple. You're only sending **email notification** A single class
can take care of it_
All good. But then comes a new requirement support SMS notification object, and send that too

slightly more complex, but still manageable.A few weeks later, products
wants to send push notification to mobile devices. Then marketing wants slack 
alerts. Then whatsapp_

Each one add another branch

`class NotificationService {
public void sendNotification(String type, String message) {
if (type.equals("EMAIL")) {
EmailNotification email = new EmailNotification();
email.send(message);
} else if (type.equals("SMS")) {
SMSNotification sms = new SMSNotification();
sms.send(message);
} else if (type.equals("Push")) {
PushNotification sms = new PushNotification();
sms.send(message);
} else if (type.equals("Slack")) {
SlackNotification sms = new SlackNotification();
sms.send(message);
} else if (type.equals("WhatsApp")) {
WhatsAppNotification sms = new WhatsAppNotification();
sms.send(message);
}
}
}`

Now this notification code is responsible for creating every kind
of notification, knowing how each one works, and deciding which to 
send based on the type


Adding a sixth notification type means 
modifying NotificationService yet again

This then becomes a nightmare to maintain 

Everytime you add a new notification channel, you must modify the same
core logic

It also violates the Open/closed principle: the class is not open
for extension without modification


Simple Factory : A First attempt

Before jumping to the full Factory Method pattern, there is a common
intermediate step: extract the creation logic into a separate class

This is called the Simple Factory

The idea is straightforward: create a separate class whose only job is 
to centralize and encapsulate object creation

