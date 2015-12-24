package com.quotetrack.model;

public enum FeedRuleActionType {
    NONE(0),
    LOG(1),
    EMAIL(2);
    
    int value;
    
    FeedRuleActionType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
};
