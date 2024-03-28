package com.chuanqi.beforeaop;

import org.junit.jupiter.api.Test;

public class TestVehicle {
    // This package shows us why we need AOP
    // This is Before AOP/proxy is used, and there is redundant code

    @Test
    void test() {
        Vehicle vehicle = new Bus();
        vehicle.run();

        vehicle = new Ship();
        vehicle.run();
    }
}
