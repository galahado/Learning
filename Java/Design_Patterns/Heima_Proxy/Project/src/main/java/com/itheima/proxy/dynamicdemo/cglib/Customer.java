package com.itheima.proxy.dynamicdemo.cglib;

public class Customer {

    public String order(String foodName) {
        return "已经下单了" + foodName;
    }

    public void test() {
        System.out.println("This is test()");
    }

    public void test2() {
        System.out.println("This is test2()");
    }
}
