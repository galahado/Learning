package com.chuanqi.usingdynamicproxy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestVehicle {
    // This package shows us why we need AOP
    // This is Before AOP/proxy is used, and there is redundant code

    private static final Logger LOGGER = LoggerFactory.getLogger(TestVehicle.class);

    @Test
    void test() {
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(new Bus());
        vehicleProxyProvider.getProxy().fly();

        vehicleProxyProvider = new VehicleProxyProvider(new Ship());
        vehicleProxyProvider.getProxy().fly();
    }
}
