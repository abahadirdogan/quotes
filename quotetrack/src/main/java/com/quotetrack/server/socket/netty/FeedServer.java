package com.quotetrack.server.socket.netty;

import com.quotetrack.server.FeedListener;
import com.quotetrack.server.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeedServer {
    private final int port;
    private final List<FeedListener> feedListeners;
    // Configure the server
    public EventLoopGroup BossGroup = new NioEventLoopGroup(1);
    public EventLoopGroup WorkerGroup = new NioEventLoopGroup();
        
    public FeedServer(int port) {
        this.port = port;
        this.feedListeners = new ArrayList<>();
    }
    
    public void runServer() {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(BossGroup, WorkerGroup)
             .channel(NioServerSocketChannel.class)
             .option(ChannelOption.SO_BACKLOG, 100)
             .option(ChannelOption.SO_REUSEADDR, true)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();
                     p.addLast(new DelimiterBasedFrameDecoder(1500, Delimiters.lineDelimiter()));
                     p.addLast(new DelimiterBasedFrameDecoder(1500, Unpooled.wrappedBuffer("@|@".getBytes())));
                     p.addLast(new FeedServerHandler(feedListeners));
                 }
             });

            // Start the server
            ChannelFuture f = b.bind(port).sync();

            // Wait until the server socket is closed
            f.channel().closeFuture().sync();
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Shut down all event loops to terminate all threads
            BossGroup.shutdownGracefully();
            WorkerGroup.shutdownGracefully();
        }
    }
    
    public void addFeedListener(FeedListener feedListener) {
        this.feedListeners.add(feedListener);
    }
}
