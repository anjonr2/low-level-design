package com.lld.behavioral.strategy.shippingcostcalculator.usingpattern;

import com.lld.behavioral.strategy.shippingcostcalculator.naive.Order;

/**
 * ShippingStrategy interface defines the contract.
 * Four concrete strategies each encapsulate a different shipping algorithm
 * The ShippingCostService context holds a strategy reference and delegates
 * calculations to it
 * ShippingStrategy interface is the common interface that all shipping strategies
 * must implement
 */
public interface ShippingStrategy {
    double calculateCost(Order order);
}

/**
 * The interface is simple and focused. Every strategy takes an order and returns
 * a cost. The interface says nothing about how the cost is calculated
 *
 * Design Decision
 *
 * We use an interface rather than an abstract class because shipping strategies
 * have no shared implementation. If they did(say, logging before calculation) an
 * abstract class with a template method might be appropriate
 */