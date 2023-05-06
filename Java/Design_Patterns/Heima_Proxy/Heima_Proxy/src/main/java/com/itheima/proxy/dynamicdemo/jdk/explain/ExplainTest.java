package com.itheima.proxy.dynamicdemo.jdk.explain;

import com.itheima.proxy.dynamicdemo.jdk.Customer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExplainTest {
    public static void main(String[] args) {

        Customer customer = new Customer();

        // 把InvocationHandler的定义抽取出来
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("order".equals(method.getName())) {
                    Object result = method.invoke(customer, args);
                    System.out.println("已经接受到订单，正前往取餐途中...");
                    System.out.println("已经取餐，正在派送...");
                    return result + ",已经搅拌均匀";
                } else {
                    return method.invoke(customer, args);
                }
            }
        };

        DeliveryClerk clerk = new DeliveryClerk(handler);
        System.out.println(clerk.order("麻婆豆腐"));
        clerk.test();
    }
}
