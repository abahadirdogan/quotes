package com.quotetrack.model;

public enum TrackRuleActionType {
    LOG(0),
    EMAIL(1);
    
    int value;
    
    TrackRuleActionType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
};
