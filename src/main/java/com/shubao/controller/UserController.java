package com.shubao.controller;

import com.shubao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\Javademo\\spring\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.save();

        /**
         Exception in thread "main" java.lang.NullPointerException
         at com.shubao.service.impl.UserServiceImpl.save(UserServiceImpl.java:16)
         at com.shubao.controller.UserController.main(UserController.java:14)
         */
//        UserService userService = new UserServiceImpl();
//        userService.save();

    }
}
