package com.quotetrack.server;

import com.quotetrack.model.FeedRuleCollection;

public class Server {
    private final FeedRuleCollection rules;
    private FeedManager feedManager;
    
    public Server(FeedRuleCollection rules) {
        this.rules = rules;
    }

    public FeedRuleCollection getRules() {
        return rules;
    }

    
}
