package com.shubao.test;

import com.shubao.config.SpringConfiguration;
import com.shubao.dao.UserDao;
import com.shubao.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
//        userDao.save();
    }

    /**
     * 测试通过注解的方式配置类
     */
    private static void testConguration(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.save();
    }

    private static void testAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.save();
//        applicationContext.close();
    }

    /**
     * 学习Spring配置文件注入方式
     */
    private static void testApplication(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\Javademo\\spring\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.save();

        /*
         Exception in thread "main" java.lang.NullPointerException
         at com.shubao.service.impl.UserServiceImpl.save(UserServiceImpl.java:16)
         at com.shubao.controller.UserController.main(UserController.java:14)
         */
//        UserService userService = new UserServiceImpl();
//        userService.save();
    }

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) context.getBean("userDao");
//        userDao.save();

//        testApplication();
//        testAnnotation();
        testConguration();

    }
}
