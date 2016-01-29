package com.quotetrack.server.feedcollector;

import com.quotetrack.server.FeedListener;
import com.quotetrack.model.Quote;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.List;

class FeedServerHandler extends ChannelInboundHandlerAdapter {

    private final List<FeedListener> feedListeners;

    FeedServerHandler(List<FeedListener> feedListeners) {
        this.feedListeners = feedListeners;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        int readerIndex = buf.readerIndex();
        buf.getBytes(readerIndex, bytes);
        Quote q = Quote.parse(new String(bytes));
        feedListeners.stream().forEach((FeedListener l) -> l.feedReceived(q));
    }

}
