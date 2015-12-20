package com.quotetrack.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class FeedRuleCollection {
    
    //<Symbol, <Id, FeedRule>
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, FeedRule>> rules;
    public FeedRuleCollection() {
        this.rules = new ConcurrentHashMap<>();
    }
    
    public void addRule(FeedRule rule) {
        ConcurrentHashMap<String, FeedRule> symbolRuleMap = rules.get(rule.getSymbol().getName());
        if (symbolRuleMap == null) {
            symbolRuleMap = new ConcurrentHashMap<>();
        }
        symbolRuleMap.put(rule.getID(), rule);
        rules.put(rule.getSymbol().getName(), symbolRuleMap);
    }
    
    public void removeRule(FeedRule rule) {
        ConcurrentHashMap<String, FeedRule> symbolRuleMap = rules.get(rule.getSymbol().getName());
        if (symbolRuleMap == null) {
            return;
        }
        symbolRuleMap.remove(rule.getID());
    }
    
    public Collection<FeedRule> getRulesBySymbol(final String symbol) {
        if (rules.get(symbol)==null)
            return new ArrayList<>();
        return rules.get(symbol).values();
    }
    
}
