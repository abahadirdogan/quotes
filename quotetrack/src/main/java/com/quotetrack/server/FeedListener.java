package com.quotetrack.server;

import com.quotetrack.model.Quote;

public interface FeedListener {
    public void feedReceived(Quote quote);
}
