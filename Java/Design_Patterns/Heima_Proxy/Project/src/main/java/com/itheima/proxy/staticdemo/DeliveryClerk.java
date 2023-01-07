package com.itheima.proxy.staticdemo;

public class DeliveryClerk extends Customer {

    @Override
    public String order(String foodName) {
        String order = super.order(foodName);
        System.out.println("已经接受到订单，正前往取餐途中...");
        System.out.println("已经取餐，正在派送...");
        return order + ", 已经搅拌均匀";
    }
}
