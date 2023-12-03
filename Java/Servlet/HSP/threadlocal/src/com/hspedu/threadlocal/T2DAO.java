package com.hspedu.threadlocal;

public class T2DAO {

    public void update() {
        //取出线程关联的threadLocal1对象的的数据
        Object o = T1.threadLocal1.get();
        //获取当前线程名
        String name = Thread.currentThread().getName();
        System.out.println("在T2DAO的update() 线程是= " + name + " 取出dog=" + o);
    }

}
