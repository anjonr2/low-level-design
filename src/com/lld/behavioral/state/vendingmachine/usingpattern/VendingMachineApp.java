package com.lld.behavioral.state.vendingmachine.usingpattern;

import com.lld.behavioral.state.vendingmachine.naive.VendingMachine;

public class VendingMachineApp {
    public static void main(String [] args){
        VendingMachine vm = new VendingMachine();

        vm.insertCoin(1.0); //Rejected - no item selected
        vm.selectItem("A1"); //Transitions to ItemSelectedState
        vm.insertCoin(1.5); //Transitions to HasMoneyState
        vm.dispenseItem(); //Dispenses, resets to IdleState
    }
}

/**
 * By using the State pattern
 * we have transformed a rigid condition-heavy implementation into a clean
 * flexible architecture where behaviors and transitions are clearly defined, decoupled
 * and easy to maintain .
 *
 * Adding a new state like OutOfStockState means creating one new class that implements
 * MachineState. No existing state classes or the context need to change
 */
