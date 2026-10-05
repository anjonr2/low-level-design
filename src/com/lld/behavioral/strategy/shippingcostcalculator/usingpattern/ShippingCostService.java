package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

/**
 * The context class holds a reference to a strategy
 * and delegates calculations to it
 */
public class ShippingCostService {
    private ShippingStrategy strategy;

    //Constructor to set initial strategy
    public ShippingCostService(ShippingStrategy strategy){
        this.strategy = strategy;
    }

    //Method to change strategy at runtime
    public void setStrategy(ShippingStrategy strategy){
        System.out.println("ShippingCostService: Strategy changed to "+ strategy.getClass().getSimpleName());
        this.strategy = strategy;
    }

    public double calculateShippingCost(Order order){
        if(strategy == null){
            throw new IllegalStateException("Shipping strategy not set");
        }

        double cost = strategy.calculateCost(order);
        System.out.println("ShippingCostService: Final Calculated Shipping Cost: $"+ cost
        + "(using "+ strategy.getClass().getSimpleName() + ")");
        return cost;
    }
}

/**
 * The context is deliberately simple
 * It stores a strategy, provides a way to change to it
 * and delegates calculations
 * It does not know or care which concrete strategy is being used
 */