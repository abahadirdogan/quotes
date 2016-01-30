package com.quotetrack.server.feedpublisher;

import com.quotetrack.server.FeedManager;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketServer implements ClientConnectionServer {

    private final FeedManager feedManager;
    private final Map<String, Set<String>> symbolClientSubscriptions;
    
    public WebSocketServer(FeedManager feedManager) {
        this.feedManager = feedManager;
        this.symbolClientSubscriptions = new ConcurrentHashMap<>();
    }
    
    public void runServer() {
        feedManager.getQuoteSymbols();
    }

    @Override
    public void publishMessage(Message message) {
        
    }
    
    public void publishQuoteMessage(QuoteMessage message) {

    }

}
