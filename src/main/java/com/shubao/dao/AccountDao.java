package com.shubao.dao;

public interface AccountDao {

//    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void out(String name, double money);

    void in(String name, double money);
}
