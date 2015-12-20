package com.quotetrack.model;

public class Quote {
    private String symbol;
    private double bid;
    private double ask;
    private long timestamp;

    public Quote(String symbol, double bid, double ask, long timestamp) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Quote{" + "symbol=" + symbol + ", bid=" + bid + ", ask=" + ask + ", timestamp=" + timestamp + '}';
    }
    
}
