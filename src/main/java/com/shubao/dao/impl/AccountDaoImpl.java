package com.shubao.dao.impl;

import com.shubao.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
