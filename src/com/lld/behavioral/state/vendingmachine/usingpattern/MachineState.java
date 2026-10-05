package com.lld.behavioral.state.vendingmachine.usingpattern;


/**
 * This MachineState interface declares
 * all the operations the vending machine supports
 * Each state will implement this interface, defining
 * how the vending machine should behave when in that state
 */
public interface MachineState {
    void selectItem(VendingMachine context, String itemCode);
    void insertCoin(VendingMachine context, double amount);
    void dispenseItem(VendingMachine context);
}

/**
 * here every method takes the context as a parameter
 * This allows each state to read context data (like the selected item)
 * and trigger transitions by calling context.setState(...)
 */