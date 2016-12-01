package com.csmarton.hackerrank.multithread;

public class VolatileTest {

    private static volatile boolean running = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!running) {}

            System.out.println("Started.");

            while (running) {}

            System.out.println("Stopped.");
        }).start();

        Thread.sleep(1000);

        System.out.println("Starting..");

        running = true;

        Thread.sleep(1000);

        System.out.println("Stopping..");

        running = false;
    }
}
