package com.itheima.proxy.staticdemo;

public class Customer implements OrderInterface{

    @Override
    public String order(String foodName){
        // 上万行
        return "已经下单点了"+foodName;
    }

    public void test(){}

    public void test2(){}
}
