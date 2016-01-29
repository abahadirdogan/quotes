package com.quotetrack.server.feedcollector;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.server.ActiveObject;
import com.quotetrack.server.FeedListenerImpl;
import com.quotetrack.server.FeedManager;
import io.netty.util.concurrent.Future;


public class FeedCollectorServer extends ActiveObject {
    private final FeedRuleCollection rules;
    private final FeedManager feedManager;
    private final FeedServer feedServer;
    private final ManagementServer managementServer;
    
    public FeedCollectorServer(int port, FeedRuleCollection rules) {
        super(true);
        this.rules = rules;
        this.feedManager = new FeedManager(rules);
        this.feedServer = new FeedServer(port);
        this.managementServer = new ManagementServer(rules);
        this.feedServer.addFeedListener(new FeedListenerImpl(feedManager));
    }

    public FeedRuleCollection getRules() {
        return rules;
    }

    @Override
    public void task() {
        feedServer.runServer();
        managementServer.runServer();
    }
    
    @Override
    public void stop() {
        try {
            System.out.println("Stopping server...");
            super.stop();
            Future<?> f = feedServer.BossGroup.shutdownGracefully();
            f.syncUninterruptibly();
            f = feedServer.WorkerGroup.shutdownGracefully();
            f.syncUninterruptibly();
            System.out.println("Stopped server...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
