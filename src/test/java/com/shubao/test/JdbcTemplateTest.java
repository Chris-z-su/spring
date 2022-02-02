package com.shubao.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    /**
     * 测试JdbcTemplate开发步骤
     */
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/wollo");
        dataSource.setUser("root");
        dataSource.setPassword("1106135");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象，知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int i = jdbcTemplate.update("insert into account value(?, ?)", "tom", 5000);
        System.out.println(i);
    }

    @Test
    /**
     * 测试Spring产生JdbcTemplate模板对象
     */
    public void test2() throws PropertyVetoException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        //执行操作
        int i = jdbcTemplate.update("insert into account value(?, ?)", "lisi", 8000);
        System.out.println(i);
    }
}
