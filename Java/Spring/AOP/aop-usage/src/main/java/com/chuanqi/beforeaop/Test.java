package com.chuanqi.beforeaop;

public class Test {

    // This package shows us why we need AOP
    // This is Before AOP/proxy is used, and there is redundant code
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        vehicle.run();

        vehicle = new Ship();
        vehicle.run();
    }
}
