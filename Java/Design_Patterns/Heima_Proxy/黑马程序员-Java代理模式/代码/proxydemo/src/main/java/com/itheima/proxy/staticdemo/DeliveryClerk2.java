package com.itheima.proxy.staticdemo;

public class DeliveryClerk2 implements OrderInterface {

    // 把原来的对象传入，并报存到成员位置。也就是目标类对象
    private OrderInterface source;

    public DeliveryClerk2(OrderInterface source) {
        this.source = source;
    }

    @Override
    public String order(String foodName) {
        String result = source.order(foodName);
        System.out.println("已经接受到订单，正前往取餐途中...");
        System.out.println("已经取餐，正在派送...");
        return result+",已经搅拌均匀";
    }

    @Override
    public void test() {
        source.test();
    }

    @Override
    public void test2() {
        source.test2();
    }
}
