package com.chuanqi.usingdynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

public class VehicleProxyProvider {
    private Vehicle targetVehicle;

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleProxyProvider.class);

    public VehicleProxyProvider(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    public Vehicle getProxy() {

        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();
        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();

        return (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, (o, method, args) -> {
            LOGGER.info("The vehicle started...");
            Object result = method.invoke(targetVehicle, args);
            LOGGER.info("The vehicle stopped...");
            return result;
        });
    }
}
