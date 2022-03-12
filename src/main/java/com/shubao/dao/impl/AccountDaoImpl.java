package com.shubao.dao.impl;

import com.shubao.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired //注入
    private JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    /**
     * 转出
     * @param name
     * @param money
     */
    @Override
    public void out(String name, double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?", money, name);
    }

    /**
     * 转入
     * @param name
     * @param money
     */
    @Override
    public void in(String name, double money) {
        jdbcTemplate.update("update account set money = money + ? where name = ?", money, name);
    }
}
