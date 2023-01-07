package com.itheima.proxy.dynamicdemo.jdk;

import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Order deliveryClerk = (Order) Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(),
                ((proxy, method, args1) -> {
                    if ("order".equals(method.getName())) {
                        Object result = method.invoke(customer, args1);
                        System.out.println("已经接受到订单，正前往取餐途中...");
                        System.out.println("已经取餐，正在派送...");
                        return result + ", 已经搅拌均匀";
                    } else return method.invoke(customer, args1);
                })
        );

        String result = deliveryClerk.order("麻婆豆腐");
        System.out.println(result);

        deliveryClerk.test();
    }
}
