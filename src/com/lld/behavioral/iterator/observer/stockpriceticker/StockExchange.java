package com.lld.behavioral.iterator.observer.stockpriceticker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange {
    private final Map<String, Double> prices = new HashMap<>();
    private final List<StockObserver> observers = new ArrayList<>();
    private String lastUpdatedSymbol;

    public void registerObserver(StockObserver observer){
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(StockObserver observer : observers){
            observer.onPriceUpdate(this);
        }
    }

    public void updatePrice(String symbol, double price){
        prices.put(symbol, price);
        lastUpdatedSymbol = symbol;
        System.out.println("\nExchange: "+ symbol + " updated to $"+price);
        notifyObservers();
    }

    public double getPrices(String symbol) {
        return prices.get(symbol);
    }

    public String getLastUpdatedSymbol() {
        return lastUpdatedSymbol;
    }
}
