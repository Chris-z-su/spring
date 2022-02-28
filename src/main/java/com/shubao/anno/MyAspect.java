package com.shubao.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

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
@Component("myAspect")
@Aspect //表示当前MyAspect是一个切面类
public class MyAspect {

    //定义切点表达式方法
    @Pointcut("execution(* com.shubao.anno.*.*(..))")
    public void myPointcut(){}

    //配置前置通知
    @Before("execution(* com.shubao.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。。");
    }

    //Proceeding JoinPoint 正在执行的连接点
//    @Around("execution(* com.shubao.anno.*.*(..))")
    @Around("myPointcut()")
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

//    @After("execution(* com.shubao.anno.*.*(..))")
    @After("MyAspect.myPointcut()")
    public void after() {
        System.out.println("最终增强");
    }
}
