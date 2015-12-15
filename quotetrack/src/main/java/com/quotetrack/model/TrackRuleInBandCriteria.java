/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotetrack.model;

/**
 *
 * @author destek
 */
public class TrackRuleInBandCriteria extends TrackRuleCriteria {

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
