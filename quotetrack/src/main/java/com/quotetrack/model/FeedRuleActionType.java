package com.quotetrack.model;

public enum FeedRuleActionType {
    LOG(0),
    EMAIL(1);
    
    int value;
    
    FeedRuleActionType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
};
