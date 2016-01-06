package com.quotetrack.server;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.server.socket.netty.FeedServer;


public class Server extends ActiveObject {
    private final FeedRuleCollection rules;
    private final FeedManager feedManager;
    private final FeedServer feedServer;
    
    public Server(int port, FeedRuleCollection rules) {
        super(true);
        this.rules = rules;
        this.feedManager = new FeedManager(rules);
        this.feedServer = new FeedServer(port);
        this.feedServer.addFeedListener(new FeedListenerImpl(feedManager));
    }

    public FeedRuleCollection getRules() {
        return rules;
    }

    @Override
    public void task() {
        feedServer.runServer();
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping server...");
        super.stop();
        feedServer.BossGroup.shutdownGracefully();
        feedServer.WorkerGroup.shutdownGracefully();
        System.out.println("Stopped server...");
    }
}
