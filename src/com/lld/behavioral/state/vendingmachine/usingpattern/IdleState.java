package com.lld.behavioral.state.vendingmachine.usingpattern;


/**
 * In this state machine is waiting for user input
 * The only valid action is selecting an item
 * Inserting coins or dispensing without selecting first
 * should be rejected
 */
public class IdleState implements MachineState{

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item selected: "+ itemCode);
        context.setSelectedItem(itemCode);
        context.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please select an item before inserting coins.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("No item selected. Nothing to dispense");
    }
}
