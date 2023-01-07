package com.itheima.proxy.dynamicdemo.jdk.explain;

import com.itheima.proxy.dynamicdemo.jdk.OrderInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 此处我们模拟一下Proxy.newProxyInstance(ClassLoader loader,
 *                                           Class<?>[] interfaces,
 *                                           InvocationHandler h)方法中做的事情，从底层看一看到底JDK如何完成的动态代理
 */
public class DeliveryClerk implements OrderInterface {

    // 接收外部传递过来的InvocationHandler对象
    private final InvocationHandler handler;

    public DeliveryClerk(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public String order(String foodName) {
        //每个方法的实现，实际上并没有做其他的事情，而是直接调用了InvocationHandler中的invoke方法

        try {
            // 调用的是order方法，则反射获取order对应的method对象，传入invoke中
            Method method = OrderInterface.class.getMethod("order", String.class);
            // 调用InvocationHandler中的invoke方法
            Object result = handler.invoke(this, method, new Object[]{foodName});
            // 将返回值返回
            return (String) result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public void test() {
        //每个方法的实现，实际上并没有做其他的事情，而是直接调用了InvocationHandler中的invoke方法

        try {
            // 调用的是test方法，则反射获取test对应的method对象，传入invoke中
            Method method = OrderInterface.class.getMethod("test");
            // 调用InvocationHandler中的invoke方法
            Object result = handler.invoke(this, method,null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void test2() {
        //每个方法的实现，实际上并没有做其他的事情，而是直接调用了InvocationHandler中的invoke方法

        try {
            // 调用的是test2方法，则反射获取test2对应的method对象，传入invoke中
            Method method = OrderInterface.class.getMethod("test2");
            // 调用InvocationHandler中的invoke方法
            Object result = handler.invoke(this, method,null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
