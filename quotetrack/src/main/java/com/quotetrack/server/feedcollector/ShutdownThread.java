package com.quotetrack.server.feedcollector;



public class ShutdownThread extends Thread {

    private FeedCollectorServer server;

    public ShutdownThread(FeedCollectorServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("Shutdown started");
        server.stop();
        System.out.println("Shutdown completed");
    }
}
