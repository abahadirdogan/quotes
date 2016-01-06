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
public class ShutdownThread extends Thread {

    private Server server;

    public ShutdownThread(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("Shutdown started");
        server.stop();
        System.out.println("Shutdown completed");
    }
}
