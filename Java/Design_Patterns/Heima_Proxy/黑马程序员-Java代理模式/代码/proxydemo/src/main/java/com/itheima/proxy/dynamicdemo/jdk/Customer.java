package com.itheima.proxy.dynamicdemo.jdk;

public class Customer implements OrderInterface{

    @Override
    public String order(String foodName){
        // 上万行
        return "已经下单点了"+foodName;
    }

    @Override
    public void test(){
        System.out.println("我是test");
    }

    @Override
    public void test2(){}
}
