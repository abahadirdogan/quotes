package com.quotetrack.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class FeedRuleCollection {
    
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, FeedRule>> rules;
    public FeedRuleCollection() {
        this.rules = new ConcurrentHashMap<>();
    }
    
    public Collection<FeedRule> getRulesBySymbol(final String symbol) {
        if (rules.get(symbol)==null)
            return new ArrayList<>();
        return rules.get(symbol).values();
    }
    
}
