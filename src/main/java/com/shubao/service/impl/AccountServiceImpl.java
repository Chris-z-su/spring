package com.shubao.service.impl;

import com.shubao.dao.AccountDao;
import com.shubao.domain.Account;
import com.shubao.mapper.AccountMapper;
import com.shubao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
//@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountMapper accountMapper;

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

    @Override
    public void save(Account account) {
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
//            accountMapper.save(account);
//            sqlSession.commit();
//            sqlSession.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        accountMapper.save(account);

    }

    @Override
    public List<Account> findAll() {
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
//            List<Account> accountList = accountMapper.findAll();
//            sqlSession.close();
//            return accountList;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
        return accountMapper.findAll();
    }
}
