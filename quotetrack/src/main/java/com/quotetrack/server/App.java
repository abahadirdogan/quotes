package com.quotetrack.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        new App();
        Server s = new Server(10000, null);
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.stop();
        es.shutdown();
    }
    
}
