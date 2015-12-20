package com.quotetrack.model;

public class FeedRuleInBandCriteria extends FeedRuleCriteria {

    private double lowerLimit;
    private double upperLimit;
    private Side side;

    public FeedRuleInBandCriteria(double lowerLimit, double upperLimit, Side side) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.side = side;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
    
    @Override
    boolean testCriteria(final Quote quote) {
        if (getSide() == Side.BUY) {
            return quote.getAsk() > getLowerLimit() &&  quote.getAsk() < getUpperLimit();
        } else if (getSide() == Side.SELL) {
            return quote.getBid() > getLowerLimit() &&  quote.getBid() < getUpperLimit();
        }
        
        return false;
    }
    
}
