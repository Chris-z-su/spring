package com.shubao.service;

import com.shubao.dao.AccountDao;

public interface AccountService {

    void setAccountDao(AccountDao accountDao);

    void transfer(String outName, String inNamel, double money);
}
