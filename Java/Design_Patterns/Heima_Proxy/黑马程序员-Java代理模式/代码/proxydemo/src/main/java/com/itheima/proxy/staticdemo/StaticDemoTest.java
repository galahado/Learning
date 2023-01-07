package com.itheima.proxy.staticdemo;

public class StaticDemoTest {
    public static void main(String[] args) {
        /*// 创建一个顾客对象
        Customer customer = new DeliveryClerk();
        String result = customer.order("麻婆豆腐");
        System.out.println(result);*/
        // 创建一个顾客对象
        Customer customer = new Customer();
        // 创建代理对象，也就是外卖小哥对象
        OrderInterface deliveryClerk = new DeliveryClerk2(customer);
        // 调用代理对象的方法，可以看到增强之后的效果
        String result = deliveryClerk.order("红烧肉");
        System.out.println(result);
    }
}
