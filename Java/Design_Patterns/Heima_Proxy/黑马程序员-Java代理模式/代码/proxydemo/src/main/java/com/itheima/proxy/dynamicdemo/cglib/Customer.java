package com.itheima.proxy.dynamicdemo.cglib;


public class Customer{

    public String order(String foodName){
        // 上万行
        return "已经下单点了"+foodName;
    }

    public void test(){
        System.out.println("我是test");
    }

    public void test2(){}
}
