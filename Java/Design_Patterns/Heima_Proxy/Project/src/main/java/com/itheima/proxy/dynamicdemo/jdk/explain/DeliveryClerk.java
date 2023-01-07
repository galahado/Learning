package com.itheima.proxy.dynamicdemo.jdk.explain;

import com.itheima.proxy.dynamicdemo.jdk.Order;

import java.lang.reflect.InvocationHandler;

public class DeliveryClerk implements Order {

    private final InvocationHandler handler;

    public DeliveryClerk(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public String order(String foodName) {
        return null;
    }

    @Override
    public void test() {

    }

    @Override
    public void test2() {

    }
}
