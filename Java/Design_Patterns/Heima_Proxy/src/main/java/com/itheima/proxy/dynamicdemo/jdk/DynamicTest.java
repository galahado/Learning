package com.itheima.proxy.dynamicdemo.jdk;

import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Order order = (Order) Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(),
                ((proxy, method, args1) -> {
                    Object result = method.invoke(customer, args1);
                    System.out.println("已经接受到订单，正前往取餐途中...");
                    System.out.println("已经取餐，正在派送...");
                    return result + ", 已经搅拌均匀";
                })
        );

        String result = order.order("麻婆豆腐");
        System.out.println(result);
    }
}
