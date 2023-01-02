package com.itheima.proxy.staticdemo;

public class StaticDemoTest {
    public static void main(String[] args) {
        Customer customer = new DeliveryClerk();
        String order = customer.order("麻婆豆腐");
        System.out.println(order);
    }
}
