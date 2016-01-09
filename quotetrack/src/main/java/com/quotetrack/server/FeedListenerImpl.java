package com.quotetrack.server;

import com.quotetrack.model.Quote;

public class FeedListenerImpl implements FeedListener {

    private final FeedManager feedManager;

    public FeedListenerImpl(FeedManager feedManager) {
        this.feedManager = feedManager;
    }
    
    @Override
    public void feedReceived(Quote quote) {
        feedManager.putFeed(quote);
        feedManager.checkRules(quote);
    }
    
}
