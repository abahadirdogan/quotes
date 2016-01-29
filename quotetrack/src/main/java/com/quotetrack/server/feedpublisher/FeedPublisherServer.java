package com.quotetrack.server.feedpublisher;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.server.ActiveObject;
import com.quotetrack.server.FeedManager;

public class FeedPublisherServer extends ActiveObject {
    private final FeedManager feedManager;

    public FeedPublisherServer(int port, FeedRuleCollection rules) {
        super(true);
        this.feedManager = new FeedManager(rules);
    }

    @Override
    public void task() {
    }
    
    @Override
    public void stop() {
        try {
            System.out.println("Stopping server...");
            super.stop();
            System.out.println("Stopped server...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
