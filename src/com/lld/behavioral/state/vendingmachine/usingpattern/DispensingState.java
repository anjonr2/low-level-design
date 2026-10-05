package com.lld.behavioral.state.vendingmachine.usingpattern;

/**
 * The machine is actively dispensing
 * All actions should be rejected until dispensing completes
 */
public class DispensingState implements MachineState{
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Please wait dispensing in progress.");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please wait, dispensing in progress.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Already dispensing. Please wait.");
    }
}
