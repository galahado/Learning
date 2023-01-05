package com.itheima.proxy.dynamicdemo.jdk;

public class Customer implements Order {

    @Override
    public String order(String foodName) {
        return "已经下单了" + foodName;
    }

    @Override
    public void test() {

    }

    @Override
    public void test2() {

    }
}
