package com.itheima.proxy.dynamicdemo.jdk;

public class Customer implements Order {

    @Override
    public String order(String foodName) {
        return "已经下单了" + foodName;
    }

    @Override
    public void test() {
        System.out.println("This is test()");
    }

    @Override
    public void test2() {
        System.out.println("This is test2()");
    }
}