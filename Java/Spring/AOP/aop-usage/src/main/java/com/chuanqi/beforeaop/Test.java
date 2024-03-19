package com.chuanqi.beforeaop;

public class Test {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        vehicle.run();

        vehicle = new Ship();
        vehicle.run();
    }
}
