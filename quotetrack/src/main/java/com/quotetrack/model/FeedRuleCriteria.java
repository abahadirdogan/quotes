package com.quotetrack.model;

public abstract class FeedRuleCriteria {
    
    abstract boolean testCriteria(final Quote quote);
    
}
