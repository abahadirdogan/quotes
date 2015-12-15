package com.quotetrack.server;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.model.Quote;
import java.util.HashMap;
import java.util.Map;

public class FeedManager {
    private final Map<String, Quote> quotes;
    private final FeedRuleCollection rules;
    
    public FeedManager(final FeedRuleCollection rules) {
        this.quotes = new HashMap<>();
        this.rules = rules;
    }
    
    public void putFeed(Quote quote) {
        quotes.put(quote.getSymbol(), quote);
    }
    
    public Optional<Quote> getQuote(String symbol) {
        return quotes.get(symbol);
    }
    
    
    
}
