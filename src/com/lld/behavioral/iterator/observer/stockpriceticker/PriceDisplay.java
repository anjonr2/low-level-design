package com.lld.behavioral.iterator.observer.stockpriceticker;

public class PriceDisplay implements StockObserver{
    @Override
    public void onPriceUpdate(StockExchange exchange) {
        String symbol = exchange.getLastUpdatedSymbol();
        System.out.println("Display -> "+ symbol + " :$"+ exchange.getPrices(symbol));
    }
}
