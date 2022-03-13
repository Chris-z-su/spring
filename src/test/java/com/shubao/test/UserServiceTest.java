package com.shubao.test;

import com.shubao.dao.UserMapper;
import com.shubao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceTest {

    public static void main(String[] args) throws IOException {
        //创建Dao对象，当前dao层实现是手动编写的
//        UserMapper userMapper = new UserMapperImpl();
//        List<User> userList = userMapper.findAllForMybatis();
//        System.out.println("userList = " + userList);

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //查询所有
        List<User> userList = userMapper.findAllForMybatis();
        System.out.println("userList = " + userList);

        //根据id注解查询
        User user = userMapper.findOneForMybatis(1);
        System.out.println("user = " + user);
    }
}
