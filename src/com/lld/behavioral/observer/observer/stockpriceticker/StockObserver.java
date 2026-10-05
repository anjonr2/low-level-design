package com.lld.behavioral.iterator.observer.stockpriceticker;

public interface StockObserver {
    void onPriceUpdate(StockExchange exchange);
}
