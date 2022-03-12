package com.shubao.service;

public interface AccountService {

//    void setAccountDao(AccountDao accountDao);

    void transfer(String outName, String inNamel, double money);
}
