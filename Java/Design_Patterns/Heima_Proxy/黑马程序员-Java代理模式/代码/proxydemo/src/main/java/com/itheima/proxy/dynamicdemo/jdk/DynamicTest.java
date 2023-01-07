package com.itheima.proxy.dynamicdemo.jdk;


import com.itheima.proxy.dynamicdemo.jdk.explain.DeliveryClerk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicTest {
    public static void main(String[] args) {
        // 准备一个目标类对象，也就是顾客对象
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
                }else{
                    return method.invoke(customer, args);// 使用method反射调用，
                                                         // 在原对象（目标类对象）中执行该方法，
                                                         // 并不修改其逻辑。也就是说，原封不动的
                                                         // 调用原来的逻辑
                }
            }
        };
        // 使用JDK的API，动态的生成一个代理对象
        /*OrderInterface deliveryClerk = (OrderInterface) Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("order".equals(method.getName())) {
                            Object result = method.invoke(customer, args);
                            System.out.println("已经接受到订单，正前往取餐途中...");
                            System.out.println("已经取餐，正在派送...");
                            return result + ",已经搅拌均匀";
                        }else{
                            return method.invoke(customer, args);// 使用method反射调用，
                                                                // 在原对象（目标类对象）中执行该方法，
                                                                // 并不修改其逻辑。也就是说，原封不动的
                                                                // 调用原来的逻辑
                        }
                    }
                }
        );*/
        OrderInterface deliveryClerk = new DeliveryClerk(handler);
                //调用代理对象，执行对应方法
        String result = deliveryClerk.order("麻婆豆腐");
        System.out.println(result);
//        deliveryClerk.test();

    }
}
