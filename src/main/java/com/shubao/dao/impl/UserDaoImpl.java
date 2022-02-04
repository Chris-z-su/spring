package com.shubao.dao.impl;

import com.shubao.dao.UserDao;
import com.shubao.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    private List<String> stringList;
//
//    private Map<String, User> userMap;
//
//    private Properties properties;
//
//    private String username;
//
//    private int age;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public List<String> getStringList() {
//        return stringList;
//    }
//
//    public void setStringList(List<String> stringList) {
//        this.stringList = stringList;
//    }
//
//    public Map<String, User> getUserMap() {
//        return userMap;
//    }
//
//    public void setUserMap(Map<String, User> userMap) {
//        this.userMap = userMap;
//    }
//
//    public Properties getProperties() {
//        return properties;
//    }
//
//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }

//    public UserDaoImpl() {
//        System.out.println("UserDaoImpl创建。。。");
//    }

//    @PostConstruct
//    public void init(){
//        System.out.println("UserDaoImpl.init()...");
//    }
//
//    @PreDestroy
//    public void destroy(){
//        System.out.println("UserDaoImpl.destroy()...");
//    }

    @Override
    public Long save(User user) {
//        System.out.println("Start running UserDaoImpl.save()...");
//        System.out.println("username: " + username + ", age: " + age);
//        System.out.println("stringList: " + stringList);
//        System.out.println("userMap: " + userMap);
//        System.out.println("properties: " + properties);
//        jdbcTemplate.update("insert into sys_user values(?, ?, ?, ?, ?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
//        System.out.println("end running UserDaoImpl.save()...");

        //1.创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //使用原始jdbc完成PreparedStatement的创建
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        //2.创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);

        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId;//返回当前保存的用户的id，是数据库自动生成的
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?, ?)", userId, roleId);
        }
    }

    @Override
    public void deleteUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }
}
