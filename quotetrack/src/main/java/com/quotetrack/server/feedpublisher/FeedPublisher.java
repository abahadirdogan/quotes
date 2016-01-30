package com.quotetrack.server.feedpublisher;

import com.quotetrack.server.ActiveObject;
import com.quotetrack.server.FeedManager;

public class FeedPublisher extends ActiveObject {

    public FeedPublisher(final FeedManager feedManager) {
        super(true);
    }
    
    @Override
    public void task() {
        
    }
    
}
