package com.shubao.test;

import com.shubao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    /**
     * 查询操作
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        List<User> userList = sqlSession.selectList("userMapper.findAllForMybatis");
        //打印数据
        System.out.println("userList = " + userList);
        //释放资源
        sqlSession.close();
    }

    /**
     * 插入操作
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //创建User对象
        User user = new User();
        user.setUsername("tom");
        user.setEmail("tom@@sinosoft.com.cn");
        user.setPassword("123");
        user.setPhoneNum("18599999999");

        //打印数据
        System.out.println("user = " + user);

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        sqlSession.insert("userMapper.insertForMybatis", user);
        //mybatis如果执行更新操作，需要手动提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 更新操作
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        //创建User对象
        User user = new User();
        user.setUsername("tom");
        user.setEmail("tom@@sinosoft.com.cn");

        //打印数据
        System.out.println("user = " + user);

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        sqlSession.update("userMapper.updateForMybatis", user);
        //mybatis如果执行更新操作，需要手动提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 删除操作
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        sqlSession.delete("userMapper.deleteForMybatis", 11);
        //mybatis如果执行更新操作，需要手动提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


}
