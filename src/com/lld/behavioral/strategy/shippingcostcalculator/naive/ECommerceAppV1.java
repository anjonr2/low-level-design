package com.lld.behavioral.strategy.shippingcostcalculator.naive;

public class ECommerceAppV1 {
    public static void main(String [] args){
        ShippingCostCalculatorNaive calculator = new ShippingCostCalculatorNaive();
        Order order1 = new Order();

        System.out.println("--- Order 1 ---");
        calculator.calculateShippingCost(order1, "FLAT_RATE");
        calculator.calculateShippingCost(order1, "WEIGHT_BASED");
        calculator.calculateShippingCost(order1, "DISTANCE_BASED");
        calculator.calculateShippingCost(order1, "THIRD_PARTY_API");

        //what if we want to try a new "PremiumZone" strategy?
        //we have to go modify this calculator class again..
    }
}

/**
 * What's wrong with this approach?
 *
 * While it may seem fine initially, this design quickly becomes brittle and problematic
 * as our system evolves:
 *
 * Violated Open/Closed principle
 *
 * Every new shipping method requires modifying the ShippingCostCalculator class. You are
 * constantly opening a class that should be stable. Each modification risks breaking existing
 * functionality
 *
 * Bloated Conditional Logic
 *
 * The if-else chain becomes increasingly large and unreadable as more strategies are
 * introduced. It clutters your code and makes debugging harder
 *
 * What we Really Need
 *
 * We need an approach where :
 *
 * 1. Each shipping algorithm lives in its own class
 * 2. Adding a new algorithm does not require modifying existing classes
 * 3. The calculator does not need to know which algorithm it is using
 * 4. Algorithms can be swapped at runtime based on user preferences or business rules
 * 5. Each algorithm can be tested independently
 *
 * This is exactly what the Strategy Pattern provides
 *
 * The Strategy Pattern defines a family of algorithms, encapsulates each one and makes
 * them interchangeable. Strategy lets the algorithm vary independently from clients
 * that use it
 *
 * Two characteristics define the pattern :
 *
 * 1. Encapsulation of algorithms: Each algorithm lives in its own class, implementing a common
 * interface. The algorithm's logic is isolated from everything else
 *
 * 2. Runtime interchangeability: The context holds a reference to the strategy interface,
 * not a concrete class. You can swap the strategy at runtime, even mid-execution, without
 * modifying the context
 *
 * Strategy pattern involves three key components
 *
 * StrategyInterface(e.g., ShippingStrategy)
 * Declares the interface common to all supported algorithms. The context uses
 * this interface to call the algorithm defined by a ConcreteStrategy
 *
 * ConcreteStrategies(e.g., FlatRateShipping, WeightBasedShipping)
 *
 * Implements the algorithm using the Strategy interface. Each concrete strategy encapsulates
 * a specific algorithm
 *
 * Context class (e.g, ShippingCostService)
 *
 * This is the main class that uses a strategy to perform a task. It holds a reference
 * to a Strategy object and delegates the calculation to it. The context doesn't know
 * or care which specific strategy is being used. It just knows that it has a strategy
 * that can calculate a shipping cost
 *
 * How it works?
 *
 * Step1: The client creates a concrete strategy object (e.g., FlatRateShipping)
 *
 * Step2: The client passes strategy to the context, either through the constructor
 * or a setter
 *
 * Step3 : The context stores the strategy interface in a field typed to the Strategy
 * Interface
 *
 * Step4: When the context needs to run the algorithm, it calls the strategy's method.
 * The context does not know or care which concrete strategy is behind the interface
 *
 * Step5: To change behavior, the client swaps in a different strategy. The context
 * code does not change at all
 */
