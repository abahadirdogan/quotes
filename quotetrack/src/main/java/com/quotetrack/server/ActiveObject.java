/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotetrack.server;

/**
 *
 * @author bd
 */
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
            task();
        }
    }
    
}
