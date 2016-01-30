package com.quotetrack.server;

import com.quotetrack.model.FeedRule;
import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.model.Quote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FeedManager {
    private final Map<String, Quote> quotes;
    private final FeedRuleCollection rules;
    private final List<FeedActionListener> actionListeners;
    
    public FeedManager(final FeedRuleCollection rules) {
        this.quotes = new HashMap<>();
        this.rules = rules;
        this.actionListeners = new ArrayList<>();
    }
    
    public void putFeed(final Quote quote) {
        System.out.println("Quote added: " + quote);
        quotes.put(quote.getSymbol(), quote);
    }
    
    public Optional<Quote> getQuote(String symbol) {
        return Optional.ofNullable(quotes.get(symbol));
    }
    
    public Set<String> getQuoteSymbols() {
        return quotes.keySet();
    }
    
    public void addFeedActionListener(FeedActionListener listener) {
        actionListeners.add(listener);
    }
    
    public void removeFeedActionListener(FeedActionListener listener) {
        actionListeners.remove(listener);
    }

    public void checkRules(final Quote quote) {
        Collection<FeedRule> matchingRules = rules.getRulesBySymbol(quote.getSymbol()).stream()
                .filter(r -> r.match(quote)).collect(Collectors.toList());
        for (FeedRule rule : matchingRules) {
            for (FeedActionListener actionListener : actionListeners) {
                actionListener.handleAction(quote, rule);
            }
        }
    }
}
