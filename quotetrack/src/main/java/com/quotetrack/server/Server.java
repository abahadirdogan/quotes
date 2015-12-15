package com.quotetrack.server;

import com.quotetrack.model.TrackRuleCollection;

public class Server {
    private final TrackRuleCollection rules;
    
    public Server(TrackRuleCollection rules) {
        this.rules = rules;
    }

    public TrackRuleCollection getRules() {
        return rules;
    }
    
    
}
