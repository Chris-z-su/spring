package com.shubao.test;

import com.shubao.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money = ? where name = ?", 15000, "zhangsan");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name = ?", "tom");
    }

    @Test
    public void testQueryAll(){
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println("list = " + list);
    }

    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "zhangsan");
//        Account account = jdbcTemplate.queryForObject("select * from account where money = ?", new BeanPropertyRowMapper<Account>(Account.class), 8000);
        System.out.println("account = " + account);
    }

    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println("count = " + count);
    }

}
