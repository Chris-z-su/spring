package com.shubao.service;

import com.shubao.domain.Account;

import java.util.List;

public interface AccountService {

//    void setAccountDao(AccountDao accountDao);

    void transfer(String outName, String inNamel, double money);

    public void save(Account account);

    public List<Account> findAll();

}
