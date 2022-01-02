package com.shubao.test;

import com.shubao.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    /**
     测试scope属性
    //单例模式
     <bean id="userDao" class="com.shubao.dao.impl.UserDaoImpl" scope="singleton"></bean>
     //多例模式
     <bean id="userDao" class="com.shubao.dao.impl.UserDaoImpl" scope="prototype"></bean>
     */
    public void testBeanScope(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) context.getBean("userDao");
        UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    @Test
    /**
     //测试Bean配置init destroy-method属性
     <bean id="userDao" class="com.shubao.dao.impl.UserDaoImpl" scope="singleton" init-method="init" destroy-method="destroy"></bean>
     */
    public void testInitDestory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao);
        //手动销毁
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    //静态工厂方式创建Bean
    public void testStaticFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao);
    }

    @Test
    //实例工厂方式创建Bean
    public void testDynamicFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao);
    }

    @Test
    /**
     * 普通数据类型注入
     */
    public void testCommonType(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }

    public static void main(String[] args) {

    }
}
