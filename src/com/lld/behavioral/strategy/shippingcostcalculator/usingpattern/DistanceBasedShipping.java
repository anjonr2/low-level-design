package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

public class DistanceBasedShipping implements ShippingStrategy{
    private double ratePerKm;

    public DistanceBasedShipping(double ratePerKm){
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with Distance-Based strategy for zone: " + order.getDestinationZone());
        switch (order.getDestinationZone()){
            case "ZONEA" :
               ratePerKm =  ratePerKm * 5.0;
            case "ZONEB" :
                ratePerKm = ratePerKm * 7.0;
            default:
                ratePerKm = ratePerKm * 10.0;
        }
        return ratePerKm;
    }
}

/**
 * Notice how each class is focused on a single responsibility
 * The DistanceBasedShipping class knows about zones
 * WeightBasedShipping class knows about weight calculations
 */