package com.itheima.proxy.dynamicdemo.jdk;

import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        // 准备一个目标类对象，也就是顾客对象，我们会创建它的动态代理
        Customer customer = new Customer();

        // 使用JDK的API，动态的生成一个代理对象
        Order deliveryClerk = (Order) Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(),
                ((proxy, method, args1) -> {
                    if ("order".equals(method.getName())) {
                        Object result = method.invoke(customer, args1);
                        System.out.println("已经接受到订单，正前往取餐途中...");
                        System.out.println("已经取餐，正在派送...");
                        return result + ", 已经搅拌均匀";
                    } else {
                        // 使用method反射调用，在原对象（目标类对象）中执行该方法，
                        // 并不修改其逻辑。也就是说，原封不动调用原来的逻辑
                        return method.invoke(customer, args1);
                    }
                })
        );

        String result = deliveryClerk.order("麻婆豆腐");
        System.out.println(result);
        deliveryClerk.test();
    }
}
