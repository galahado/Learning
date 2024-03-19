package com.chuanqi.beforeaop;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("The vehicle started...");
        System.out.println("The Bus is running");
        System.out.println("The vehicle stopped...");
    }
}
