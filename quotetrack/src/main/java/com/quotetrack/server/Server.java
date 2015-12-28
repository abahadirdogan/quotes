package com.quotetrack.server;

import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.server.socket.netty.EchoServer;


public class Server extends ActiveObject {
    private final FeedRuleCollection rules;
    private final FeedManager feedManager;
    private final EchoServer feedServer;
    
    public Server(int port, FeedRuleCollection rules) {
        super(true);
        feedManager = new FeedManager(rules);
        this.rules = rules;
        feedServer = new EchoServer(port);
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
        //super.stop();
        feedServer.BossGroup.shutdownGracefully();
        feedServer.WorkerGroup.shutdownGracefully();
    }
}
