package com.hspedu.t2;

import com.hspedu.t1.A;

public class Test {
    public static void main(String[] args) {
        //'A()' has protected access in 'com.hspedu.t1.A'
        //老师梳理
        //1. 因为A类和Test类不在同一个包
        //2. 就不能访问A类的protected 方法, 包括构造器
        //3. A<String>(){} 就是一个匿名内部类， 可以理解成是A类子类
        //4. A<String>(){} 匿名内部类, 有一个隐式的无参构造器, 根据java基础 无参构造器 有默认super()
        //5. 当你执行 new A<String>(){} 会调用到A类的无参的protected 构造器
        //6. 如果还不明白, 就回去看java基础 泛型+匿名内部类 =>API
        A a = new A<String>(){};
        System.out.println(a.getClass());//Test$1
    }
}
