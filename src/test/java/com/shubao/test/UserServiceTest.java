package com.shubao.test;

import com.shubao.dao.UserMapper;
import com.shubao.dao.impl.UserMapperImpl;
import com.shubao.domain.User;

import java.io.IOException;
import java.util.List;

public class UserServiceTest {

    public static void main(String[] args) throws IOException {
        //创建Dao对象，当前dao层实现是手动编写的
        UserMapper userMapper = new UserMapperImpl();
        List<User> userList = userMapper.findAllForMybatis();
        System.out.println("userList = " + userList);
    }
}
