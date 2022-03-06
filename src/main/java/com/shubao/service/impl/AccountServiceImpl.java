package com.shubao.service.impl;

import com.shubao.dao.AccountDao;
import com.shubao.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outName, String inName, double money) {
        accountDao.out(outName, money);
        int i = 1/0;
        accountDao.in(inName, money);
    }
}
