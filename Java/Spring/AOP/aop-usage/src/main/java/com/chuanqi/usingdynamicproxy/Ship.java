package com.chuanqi.usingdynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ship implements Vehicle {
    private static final Logger LOGGER = LoggerFactory.getLogger(Ship.class);
    @Override
    public void run() {
        LOGGER.info("The Ship is running");
    }

    @Override
    public void fly() {
        LOGGER.info("The ship cannot fly!");
    }
}
