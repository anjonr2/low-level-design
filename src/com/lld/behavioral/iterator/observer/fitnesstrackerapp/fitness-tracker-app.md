Imagine you're building a Fitness Tracker App that connects to a wearable
device. The device continuously streams real-time fitness data like
steps taken, active minutes and calories burned
This data flows into a central FitnessData object 

Now, multiple modules within your app need to react to these updates

Module
LiveActivityDisplay : Shows real-time stats on the dashboard
ProgressLogger : Persists data to a database for trend analysis
GoalNotifier : Sends alerts when the user hits milestones

The Naive approach 

In a straightforward implementation, FitnessData directly holds and manages references
to all dependent modules. It knows about each one, creates them, and calls their
specific methods whenever data changes

Understanding the observer pattern : 
The observer design pattern provides a clean and flexible solution to the 
problem of broadcasting changes from one central object (the subject) to many
dependent objects (the observers) all while keeping them loosely coupled

Two characteristics define the pattern : 

1. One-to-Many notification : A single subject can have any number of observers.
When the subject's state changes, it iterates through its list of observers and
calls an update method on each one. The subject does not know what the observers
do with the information. It just sends the signal

2. Loose coupling between subject and observers: The subject depends only on 
the observer interface, not on any concrete observer class. Observers can be
added, removed or replaced at runtime without modifying the subject. This means 
the subject and observers can vary independently


Subject Interface :  

Declares the interface for managing observers, registering, removing and notifying
them. Defines registerObserver(), removeObserver(), and notifyObservers() methods

The subject holds a list of observers typed to the observer interface
not to concrete classes. This means any class that implements the Observer interface
can register, and the subject never needs to know

2. Observer interface : Declares the update() method that the subject calls when
its state changes. All modules that wants to listen to fitness data changes will
implement this interface

3. ConcreteSubject(e.g, FitnessData): Implements the Subject interface. Holds the
actual state and notifies observers when that state changes. It maintains a list
of registered observers and calls notifyObservers() whenever its state changes

4. ConcreteObservers (e.g., LiveActivityDisplay)

Implement the Observer interface. Defines what happens when the subject's state
changes. When update() is called each observer pulls relevant data from the subject
and performs its own logic (e.g, update UI, log progress, send alerts)

How it works?

Step 1: The client creates a concrete subject and one or more concrete observers

Step 2: Each observer registers itself with the subject by calling registerObserver()

Step 3 : The subject adds the observer to its internal list

Step 4 : When the subject's state changes, it calls notifyObservers(), which iterates
through  the list and calls update() on each observer

Step 5: Each observer receives the notification and pulls the data it needs from
the subject via getter methods

Step 6: To stop receiving updates, an observer calls removeObserver().
The subject removes it from the list. Future notifications skip this observer