package com.lld.behavioral.state.vendingmachine.naive;

public class VendingMachine {
    private enum State {
        IDLE, ITEM_SELECTED, HAS_MONEY, DISPENSING
    }

    private State currentState = State.IDLE;
    private String selectedItem = "";
    private double insertedAmount = 0.0;

    public void selectItem(String itemCode){
        switch (currentState){
            case IDLE:
                selectedItem = itemCode;
                currentState = State.ITEM_SELECTED;
                break;
            case ITEM_SELECTED:
                System.out.println("Item already selected");
                break;
            case HAS_MONEY:
                System.out.println("Payment already received for item");
                break;
            case DISPENSING:
                System.out.println("Currently Dispensing");
                break;
        }
    }

    public void insertCoin(double amount){
        switch (currentState){
            case IDLE:
                System.out.println("No item selected");
                break;
            case ITEM_SELECTED:
                insertedAmount = amount;
                System.out.println("Inserted $" + insertedAmount + "for item");
                currentState = State.HAS_MONEY;
                break;
            case HAS_MONEY:
                System.out.println("Money already inserted");
                break;
            case DISPENSING:
                System.out.println("Currently Dispensing");
                break;
        }
    }

    public void dispenseItem(){
        switch (currentState){
            case IDLE:
                System.out.println("No item selected");
                break;
            case ITEM_SELECTED:
                System.out.println("Please insert amount for the item");
                break;
            case HAS_MONEY:
                System.out.println("Dispensing selected item "+ selectedItem);
                currentState = State.DISPENSING;
                System.out.println("Item dispensed successfully.");
                break;
        }
    }

    private void resetMachine(){
        selectedItem = "";
        insertedAmount = 0.0;
        currentState = State.IDLE;
    }
}

/**
 * What's wrong with this Approach
 *
 * While using an enum with switch statements can work for small, predictable systems
 * this approach doesn't scale well
 *
 * 1.Cluttered code
 * All state related logic is stuffed into a single class (VendingMachine)
 * resulting in a large repetitive switch or if-else blocks across every method.
 * This leads to code that is hard to read and reason about, duplicate checks
 * for state across multiple methods and fragile logic when multiple developers touch
 * the same file
 *
 * 2.Hard to Extend
 * Suppose you want to introduce new states
 * like OutOfStockState (when the selected item is sold out)
 * or MaintenanceState (when the machine is undergoing service)
 * To support these you would need to update every switch block
 * in every method, add logic in multiple places, and risk breaking
 * existing functionality. This violates the Open/Closed Principle
 *
 * This violates the Open/Closed Principle: the system is open to
 * modification when it should to be open to extension not modification
 *
 * 3.Violates the Single Responsibility Principle
 *
 * The VendingMachine class is now responsible for
 * managing state transitions, implementing business rules
 * and executing state-specific logic. This tight coupling
 * makes the class monolithic, hard to test, and resistant chane
 *
 * What we Really Need
 *
 * We need to encapsulate the behavior associated with each state into its
 * own class, so the vending machine can delegate work to the current state object
 * instead of managing it all internally.
 * This would allow us to avoid switch-case madness, add or remove states without
 * modifying the core class, and keep each state's logic isolated and testable
 *
 *
 * State Pattern :
 * The State pattern allows an object (the context) to alter its behavior when its internal
 * state changes. The object appears to change its class because its behavior is now
 * delegated to different state object
 *
 * Two characteristic defines the pattern :
 *
 * Encapsulation of state-specific behavior : Each state gets its own class. All the logic
 * for "what happens when the machine is idle and someone inserts a coin" lives in the IdleState
 * class, not buried in a switch statement somewhere
 *
 * State-driven transitions: State objects themselves decide when and how to transition to
 * another state. The context does not manage transitions through conditionals. It just delegates
 * to the current state, and the state handles the rest
 *
 * Real- World Analogy
 *
 * Think about a traffic light. It has three states: red, yellow, and green
 * The behavior at each state is different: car stops , cars prepare to stop
 * or cars go
 *
 * Each state knows what it does and when to transition to the next one
 * Red knows it should eventually become green
 * Green knows it should eventually become yellow
 * The traffic light itself just follows whichever state is active
 *
 * This is exactly how the state pattern works : the context ( traffic light)
 * delegates to the current state, and each state manages its own transitions
 *
 * 1.State Interface (e.g. MachineState)
 * Declares the methods that corresponds to the actions the context supports
 * Every concrete state must implement these methods, even if some are no-ops
 * in certain states
 *
 * The state interface usually passes the context as a parameter to each method
 * This lets concrete states call context.setState(new SomeOtherState()) to trigger
 * transitions
 *
 * 2.Concrete states(e.g. IdleState, ItemSelectedState)
 *
 * Each concrete state implements the State interface with behavior specific to that
 * state
 *
 * When an action in one state should move the context to a different state, the
 * concrete state creates the next state and sets it on the context
 *
 * 3.Context (e.g. VendingMachine)
 * The class that clients interacts with. It maintains a reference to the current state
 * object and delegates all operations to it
 *
 * How it works :
 * The State workflow follows a delegation
 *
 * Step1 : The context starts with an initial state (e.g : IdleState)
 *
 * Step2 : The client calls an action on the context e.g selectedItem("A1")
 *
 * Step3 : The context delegates the call to the current state
 *  currentState.selectedItem(this, "A1")
 *
 *  Step5 : the next time client calls an action, the context delegates to the new state,
 *  which may behave completely different
 *
 *
 */