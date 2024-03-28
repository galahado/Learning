package com.chuanqi.usingdynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bus implements Vehicle {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bus.class);
    @Override
    public void run() {
        LOGGER.info("The Bus is running");
    }

    public void fly() {
        LOGGER.info("The bus is flying");
    }
}
