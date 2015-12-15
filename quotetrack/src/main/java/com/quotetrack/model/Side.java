package com.quotetrack.model;

public enum Side {

    SELL(0), BUY(1);
    
    int value;

    Side(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
