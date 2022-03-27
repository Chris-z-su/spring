package com.shubao.mapper;

import com.shubao.domain.Account;

import java.util.List;

public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();
}
