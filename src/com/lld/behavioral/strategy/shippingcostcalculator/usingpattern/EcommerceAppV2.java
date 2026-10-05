package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

public class EcommerceAppV2 {
    public static void main(String [] args){
        Order order1 = new Order();

        //Create different strategy instances
        ShippingStrategy flatRate = new FlatRateShipping(10.0);
        ShippingStrategy weightBased = new WeightBasedShipping(2.5);
        ShippingStrategy distanceBased = new DistanceBasedShipping(5.0);

        //create context with a initial strategy
        ShippingCostService shippingService = new ShippingCostService(flatRate);

        System.out.println("---Order 1: using flat rate (initial) --- ");
        shippingService.calculateShippingCost(order1);

        System.out.println("\n--- Order 1: Changing to weight-based ---");
        shippingService.setStrategy(weightBased);
        shippingService.calculateShippingCost(order1);

        System.out.println("\n--- Order 1: Changing to distance-based ---");
        shippingService.setStrategy(distanceBased);
        shippingService.calculateShippingCost(order1);

        /**
         * Adding a NEW strategy is easy:
         *
         * 1. Create a new class implementing ShippingStrategy (e.g., FreeShippingStrategy)
         * No modification to ShippingCostService is needed
         */
    }
}

/**
 * Notice how clean this is. No conditional logic inside ShippingCostService
 * Strategies are encapsulated, reusable and easy to test.
 *
 * Adding a new strategy say (FreeShippingForPrimeMembers) only requires
 * creating a new class that implements ShippingStrategy. No changes
 * to the service or existing strategies. You can switch strategies at runtime
 * without breaking any existing functionality
 *
 * What we Gained
 *
 * Let us evaluate what the strategy pattern has given us
 *
 * Open/Closed principle
 *
 * The ShippingCostCalculator is now closed for modification
 * To add a new shipping method, you can create a new strategy
 * class. The existing code remains unchanged
 *
 * Single Responsibility
 *
 * Each strategy class has one job: calculate shipping cost using a specific
 * algorithm. The calculator has one job: orchestrate calculation by delegating to a strategy
 *
 * Runtime flexibility
 *
 * Strategies can be swapped at any time. A user might start with
 * standard shipping and upgrade to express during checkout. The system
 * handles this seamlessly
 *
 * Composition over inheritance
 *
 * The calculator and strategies are separate objects. Changes to one do not
 * ripple through the others
 */