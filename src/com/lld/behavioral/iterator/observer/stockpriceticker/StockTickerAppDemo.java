package com.lld.behavioral.iterator.observer.stockpriceticker;

public class StockTickerAppDemo {
    public static void main(String [] args){
        StockExchange exchange = new StockExchange();

        PriceDisplay display = new PriceDisplay();
        AlertService alerts = new AlertService();

        exchange.registerObserver(display);
        exchange.registerObserver(alerts);

        alerts.setAlert("AAPL", 180.0);
        alerts.setAlert("GOOG", 140.0);

        exchange.updatePrice("AAPL", 175.50);
        exchange.updatePrice("GOOG", 138.80);
    }
}
