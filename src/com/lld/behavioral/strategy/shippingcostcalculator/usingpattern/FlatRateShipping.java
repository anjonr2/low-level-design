package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

/**
 * Concrete strategy classes
 */

public class FlatRateShipping implements ShippingStrategy{
    private double rate;

    public FlatRateShipping(double rate){
        this.rate = rate;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with Flat Rate strategy ($" + rate + ")");
        return rate;
    }
}
