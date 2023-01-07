package com.itheima.proxy.dynamicdemo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicTest {
    public static void main(String[] args) {
        // 创建一个目标类对象，也就是顾客对象
        Customer customer = new Customer();
        // 使用CGLIB创建代理对象
        Customer deliveryClerk = (Customer) Enhancer.create(customer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 判断，如果是order方法，则增强
                if("order".equals(method.getName())){
                    Object result = method.invoke(customer, args);
                    System.out.println("已获得订单，去取餐路上...");
                    System.out.println("已取餐，正在送餐...");
                    return result +",额外添加美味佐料：口水一下";
                }else{
                    return method.invoke(customer, args);// 原封不动的调用原来的逻辑。反射调用
                }
            }
        });
        // 调用代理类的方法
        String result = deliveryClerk.order("鱼香肉丝");
        System.out.println(result);
    }
}
