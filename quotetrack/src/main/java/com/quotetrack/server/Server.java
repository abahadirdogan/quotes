package com.quotetrack.server;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.server.socket.netty.FeedServer;
import io.netty.util.concurrent.Future;


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
