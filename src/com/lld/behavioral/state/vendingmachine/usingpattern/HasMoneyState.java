package com.lld.behavioral.state.vendingmachine.usingpattern;

/**
 * Money has been inserted
 * The machine is ready to dispense
 * Selecting a new item or inserting more money
 * should be rejected
 */
public class HasMoneyState implements MachineState{
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Cannot change item after inserting money");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Money already inserted.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Dispensing item: "+ context.getSelectedItem());
        context.setState(new DispensingState());
        System.out.println("Item dispensed successfully");
        context.reset();
    }
}
