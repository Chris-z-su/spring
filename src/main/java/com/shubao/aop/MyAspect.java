package com.shubao.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 输出顺序：
     前置增强。。。。
     环绕前增强。。。。
     save() running...
     最终增强
     环绕后增强。。。。
     后置增强。。。。
 *
 */
public class MyAspect {

    public void before(){
        System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。。");
    }

    //Proceeding JoinPoint 正在执行的连接点
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强。。。。");
        //切点方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强。。。。");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强。。。。");
    }

    public void after() {
        System.out.println("最终增强");
    }
}
