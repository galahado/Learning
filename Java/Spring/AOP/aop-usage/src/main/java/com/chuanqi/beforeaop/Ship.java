package com.chuanqi.beforeaop;

public class Ship implements Vehicle{
    @Override
    public void run() {
        System.out.println("The vehicle started...");
        System.out.println("The Ship is running");
        System.out.println("The vehicle stopped...");
    }
}
