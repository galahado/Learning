package com.itheima.proxy.dynamicdemo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Customer clerk = (Customer) Enhancer.create(customer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if ("order".equals(method.getName())) {
                    Object result = method.invoke(customer, objects);
                    System.out.println("已经接受到订单，正前往取餐途中...");
                    System.out.println("已经取餐，正在派送...");
                    return result + ", 已经搅拌均匀";
                } else {
                    // 使用method反射调用，在原对象（目标类对象）中执行该方法，
                    // 并不修改其逻辑。也就是说，原封不动调用原来的逻辑
                    return method.invoke(customer, objects);
                }
            }
        });

        System.out.println(clerk.order("麻婆豆腐"));
    }
}
