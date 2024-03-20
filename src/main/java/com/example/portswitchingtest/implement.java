package com.example.portswitchingtest;

import java.io.IOException;
import java.net.ServerSocket;

public class implement {

    public static void main(String[] args) {
        final int PORT_5160 = 5160;
        final int PORT_5200 = 5200;

        // Start monitoring thread for port 5200
        Thread monitor5200Thread = new Thread(() -> {
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(PORT_5200)) {
                    System.out.println("Port 5200 is connected.");
                    serverSocket.accept(); // This will block until a connection is made
                } catch (IOException e) {
                    System.out.println("Port 5200 is disconnected.");
                    switchToPort5160();
                }
            }
        });
        monitor5200Thread.start();

        // Start monitoring thread for port 5160
        Thread monitor5160Thread = new Thread(() -> {
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(PORT_5160)) {
                    System.out.println("Port 5160 is connected.");
                    serverSocket.accept(); // This will block until a connection is made
                } catch (IOException e) {
                    System.out.println("Port 5160 is disconnected.");
                    switchToPort5200();
                }
            }
        });
        monitor5160Thread.start();
    }

    private static void switchToPort5160() {
        // Code to handle switching to port 5160
        // For demonstration purpose, I'll just print a message
        System.out.println("Switching to port 5160...");
    }

    private static void switchToPort5200() {
        // Code to handle switching to port 5200
        // For demonstration purpose, I'll just print a message
        System.out.println("Switching to port 5200...");
    }
}