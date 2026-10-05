package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

public class WeightBasedShipping implements ShippingStrategy{
    private final double ratePerKg;

    public WeightBasedShipping(double ratePerKg){
        this.ratePerKg = ratePerKg;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with Weight-based strategy ($" + ratePerKg + "/kg");
        return order.getTotalWeight() * ratePerKg;
    }
}
