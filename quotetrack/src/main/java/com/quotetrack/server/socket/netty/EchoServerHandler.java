package com.quotetrack.server.socket.netty;

import com.quotetrack.model.Quote;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.ConcurrentLinkedQueue;

class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private final ConcurrentLinkedQueue<Quote> queue;

    EchoServerHandler(ConcurrentLinkedQueue<Quote> queue) {
        this.queue = queue;
    }
    
}
