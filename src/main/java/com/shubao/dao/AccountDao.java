package com.shubao.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AccountDao {

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void out(String name, double money);

    void in(String name, double money);
}
