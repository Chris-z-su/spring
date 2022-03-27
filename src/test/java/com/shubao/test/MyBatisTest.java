package com.shubao.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shubao.domain.Order;
import com.shubao.domain.User;
import com.shubao.mapper.OrderMapper;
import com.shubao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

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
        user.setPhoneNum("19911001122");

        //打印数据
        System.out.println("user = " + user);

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true表示不需要手动提交事务
        //执行操作，参数：namespace + id
        sqlSession.insert("userMapper.insertForMybatis", user);
        //mybatis如果执行更新操作，需要手动提交事务
//        sqlSession.commit();
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

    /**
     * 查询一个对象
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        User user = sqlSession.selectOne("userMapper.findOneForMybatis", 1);
        //打印数据
        System.out.println("user = " + user);
        //释放资源
        sqlSession.close();
    }


    /**
     * 自定义类型转换器：保存一个对象
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建User对象
        User user = new User();
        user.setUsername("sakura");
        user.setPassword("123456");
        user.setEmail("sakura@gmail.com");
        user.setPhoneNum("18899523266");
        user.setBirthday(new Date("2002/05/20"));

        //执行保存操作
        userMapper.save(user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


    /**
     * 自定义类型转换器：查询
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByid(15);
        System.out.println("user = " + user);

        //释放资源
        sqlSession.close();
    }


    /**
     * 分页插件：PageHelper
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //设置分页的相关参数  当前页、每页显示的条数
        PageHelper.startPage(3, 3);

        List<User> userList = userMapper.findAllForMybatis();
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        //获得与分页相关的数据
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示的条数：" + pageInfo.getPageSize());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否是第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页：" + pageInfo.isIsLastPage());


        //释放资源
        sqlSession.close();
    }

    /**
     * 多表联合查询：一对一
     * @throws IOException
     */
    @Test
    public void test9() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println("order = " + order);
        }

        //释放资源
        sqlSession.close();
    }


    /**
     * 多表联合查询：一对多
     * @throws IOException
     */
    @Test
    public void test10() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        //释放资源
        sqlSession.close();
    }

    /**
     * 多表联合查询：多对多  三表
     * @throws IOException
     */
    @Test
    public void test11() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace + id
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserAndRole();
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test12() throws IOException {
        User user = new User();
        user.setUsername("wangwu");
        user.setEmail("wangwu@gmail.com");
        user.setPassword("123");
        user.setPhoneNum("110119120");

        userMapper.save(user);
    }

    @Test
    public void test13() throws IOException {
        List<User> userList = userMapper.findAllForMybatis();
        System.out.println(userList);
    }


}
