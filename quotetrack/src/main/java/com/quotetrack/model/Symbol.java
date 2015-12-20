package com.quotetrack.model;

public class Symbol {
    private String name;
    private int digit;
    private String leftSymbol;
    private String rightSymbol;

    public Symbol(String name, int digit, String leftSymbol, String rightSymbol) {
        this.name = name;
        this.digit = digit;
        this.leftSymbol = leftSymbol;
        this.rightSymbol = rightSymbol;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String getLeftSymbol() {
        return leftSymbol;
    }

    public void setLeftSymbol(String leftSymbol) {
        this.leftSymbol = leftSymbol;
    }

    public String getRightSymbol() {
        return rightSymbol;
    }

    public void setRightSymbol(String rightSymbol) {
        this.rightSymbol = rightSymbol;
    }
    
}
