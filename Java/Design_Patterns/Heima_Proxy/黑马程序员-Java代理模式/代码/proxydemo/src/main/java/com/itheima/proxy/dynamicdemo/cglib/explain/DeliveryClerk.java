package com.itheima.proxy.dynamicdemo.cglib.explain;

import com.itheima.proxy.dynamicdemo.cglib.Customer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * 模拟在内存中调用CGLIB的Enhancer.create（Class type, Callback callback)方法后，该方法内部写了一个什么样的代理类
 */
public class DeliveryClerk extends Customer {
    // 保存方法拦截器
    private final MethodInterceptor methodInterceptor;

    public DeliveryClerk(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public String order(String foodName) {

        try {
            Method method = Customer.class.getMethod("order", String.class);
            Object result = methodInterceptor.intercept(this, method, new Object[]{foodName}, null);
            return (String) result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return super.order(foodName);
    }

    @Override
    public void test() {
        try {
            Method method = Customer.class.getMethod("test", String.class);
            Object result = methodInterceptor.intercept(this, method, null, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void test2() {
        try {
            Method method = Customer.class.getMethod("test2", String.class);
            Object result = methodInterceptor.intercept(this, method, null, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
