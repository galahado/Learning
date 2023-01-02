package com.mashibin.singleton;

// 饿汉式
// the only shortcoming is that when the class is loaded, it is instanced
public class Mgr01 {

    private static Mgr01 instance = new Mgr01();

    private Mgr01() {
    }

    public Mgr01 getInstance() {
        return instance;
    }
}
