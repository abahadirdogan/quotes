package com.quotetrack.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class TrackRuleCollection {
    
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, TrackRule>> rules;
    public TrackRuleCollection() {
        this.rules = new ConcurrentHashMap<>();
    }
    
    Collection<TrackRule> getRulesBySymbol(final String symbol) {
        if (rules.get(symbol)==null)
            return new ArrayList<>();
        return rules.get(symbol).values();
    }
    
}
