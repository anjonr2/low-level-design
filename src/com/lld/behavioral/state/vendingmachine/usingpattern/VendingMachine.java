package com.lld.behavioral.state.vendingmachine.usingpattern;

/**
 * VendingMachine class (our context) maintains a reference
 * to the current state and delegates all actions to it
 * It also holds the shared data that states need access to
 */
public class VendingMachine {
    private MachineState currentState;
    private String selectedItem;
    private double insertedAmount;

    public VendingMachine(){
        this.currentState = new IdleState();
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setState(MachineState currentState) {
        this.currentState = currentState;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public double getInsertedAmount() {
        return insertedAmount;
    }

    public void setInsertedAmount(double insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    public void reset(){
        this.selectedItem = "";
        this.insertedAmount = 0.0;
        this.currentState = new IdleState();
    }
}
