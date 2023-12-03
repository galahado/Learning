package com.hspedu.threadlocal;

public class T1 {

    //创建ThreadLocal对象, 做成public static.
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

    //Task 是线程类 -> 内部类 / 线程
    public static class Task implements Runnable {
        @Override
        public void run() {
            Dog dog = new Dog();
            Pig pig = new Pig();
            //给threadLocal1 对象放入set dog , 隔山打牛
            System.out.println("Task 放入了 dog= " + dog);
            /*
                老韩解读
                public void set(T value) {
                    //1. 获取当前线程, 关联到当前线程!
                    Thread t = Thread.currentThread();
                    //2. 通过线程对象, 获取到ThreadLocalMap
                    //   ThreadLocalMap 类型 ThreadLocal.ThreadLocalMap
                    ThreadLocalMap map = getMap(t);
                    //3. 如果map不为null, 将数据(dog,pig..) 放入map -key:threadLocal value:存放的数据
                    //   从这个源码我们已然看出一个threadlocal只能关联一个数据，如果你set, 就会替换
                    //4. 如果map为null, 就创建一个和当前线程关联的ThreadLocalMap, 并且该数据放入
                    if (map != null)
                        map.set(this, value);
                    else
                        createMap(t, value);
                }

             */
            threadLocal1.set(dog);
            //threadLocal1.set(pig);//替换
            threadLocal2.set(pig);//这个数据就会threadLocal2关联，并且都被当前Thread管理
            System.out.println("Task 在run 方法中 线程=" + Thread.currentThread().getName());
            new T1Service().update();
        }
    }

    public static void main(String[] args) {
        new Thread(new Task()).start();//主线程启动一个新的线程,注意不是主线程
    }
}
