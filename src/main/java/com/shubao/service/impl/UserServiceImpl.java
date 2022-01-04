package com.shubao.service.impl;

import com.shubao.dao.UserDao;
import com.shubao.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
//@Scope("prototype") //标注bean的作用范围
@Scope("singleton")
public class UserServiceImpl implements UserService {

//    @Value("${jdbc.driver}")
//    private String driver;

//    @Autowired //按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao") //按照id值从容器中进行匹配的，但是此处@Qualifier结合@Autowired一起使用
    @Resource(name = "userDao") //@Resource相当于@Autowired + @Qualifier
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    public UserServiceImpl() {
//    }
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println("start UserServiceImpl.save()...");
//        System.out.println(driver);
        userDao.save();
        System.out.println("end UserServiceImpl.save()...");
    }
}
