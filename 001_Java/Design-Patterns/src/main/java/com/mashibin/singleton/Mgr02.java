package com.mashibin.singleton;

// 饿汉式
// using static block
public class Mgr02 {

    private static Mgr02 instance;

    static {
        instance = new Mgr02();
    }

    private Mgr02() {
    }

    public Mgr02 getInstance() {
        return instance;
    }
}
