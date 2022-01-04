package com.shubao.test;

import com.shubao.config.SpringConfiguration;
import com.shubao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/*
https://blog.csdn.net/weixin_43671497/article/details/90543225
@RunWith作用
@RunWith 就是一个运行器
@RunWith(JUnit4.class) 就是指用JUnit4来运行
@RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
@RunWith(Suite.class) 的话就是一套测试集合，
@ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSpringJunitXML() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
