package com.itheima.proxy.staticdemo;

public class DeliveryClerk extends Customer{
    @Override
    public String order(String foodName) {
        String result = super.order(foodName);
        System.out.println("已经接受到订单，正前往取餐途中...");
        System.out.println("已经取餐，正在派送...");
        return result+",已经搅拌均匀";
    }

    @Override
    public void test() {
        super.test();
    }

    @Override
    public void test2() {
        super.test2();
    }
}
