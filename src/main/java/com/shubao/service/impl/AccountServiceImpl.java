package com.shubao.service.impl;

import com.shubao.dao.AccountDao;
import com.shubao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) //配置在方法上优先级最高
    @Override
    public void transfer(String outName, String inName, double money) {
        accountDao.out(outName, money);
//        int i = 1/0;
        accountDao.in(inName, money);
    }
}
