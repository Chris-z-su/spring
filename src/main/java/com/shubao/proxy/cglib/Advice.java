package com.shubao.proxy.cglib;

public class Advice {

    public void before(){
        System.out.println("前置增强。。。");
    }

    public void afterReturn(){
        System.out.println("后置增强。。。");
    }
}
