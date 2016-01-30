package com.quotetrack.server;

public abstract class ActiveObject implements Runnable {
    private boolean active;
    
    public abstract void task();
    
    public ActiveObject(boolean active) {
        this.active = active;
    }
    
    public void start() {
        active = true;
    }
    
    public void stop() {
        active=false;
    }
    
    @Override
    public void run() {
        while (active) {
            try {
                task();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Run loop finished");
    }
    
}
