package com.quotetrack.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        App app = new App();
        try {
            Server s = new Server(10001, null);
            app.attachShutDownHook(s);
            ExecutorService es = Executors.newFixedThreadPool(5);
            es.submit(s);
            s.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*ExecutorService es = Executors.newFixedThreadPool(5);
         es.submit(s);
         try {
         Thread.sleep(1000);
         } catch (InterruptedException ex) {
         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
         }
         s.stop();
         es.shutdown();*/
    }

    public void attachShutDownHook(Server server) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread(server));
        System.out.println("Shut Down Hook Attached.");
    }
}
