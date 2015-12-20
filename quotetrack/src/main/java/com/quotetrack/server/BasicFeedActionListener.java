
package com.quotetrack.server;

import com.quotetrack.model.FeedRule;
import com.quotetrack.model.Quote;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BasicFeedActionListener implements FeedActionListener {
    private final ExecutorService executor;
    private final int THREADS = 5;
    
    public BasicFeedActionListener() {
        executor = Executors.newFixedThreadPool(THREADS);
    }

    @Override
    public void handleAction(Quote quote, FeedRule rule) {
        executor.submit(()->rule.getFeedRuleAction().perform(quote, rule));
    }
    
}
