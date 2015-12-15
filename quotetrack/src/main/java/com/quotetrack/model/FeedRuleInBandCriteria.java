package com.quotetrack.model;

public class FeedRuleInBandCriteria extends FeedRuleCriteria {

    private double lowerLimit;
    private double upperLimit;
    private Side side;
    
    @Override
    boolean testCriteria(final Quote quote) {
        if (side == Side.BUY) {
            return quote.getAsk() > lowerLimit &&  quote.getAsk() < upperLimit;
        } else if (side == Side.SELL) {
            return quote.getBid() > lowerLimit &&  quote.getBid() < upperLimit;
        }
        
        return false;
    }
    
}
