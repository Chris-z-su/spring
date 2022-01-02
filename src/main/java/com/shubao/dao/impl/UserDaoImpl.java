package com.shubao.dao.impl;

import com.shubao.dao.UserDao;
import com.shubao.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> stringList;

    private Map<String, User> userMap;

    private Properties properties;

    private String username;

    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

//    public UserDaoImpl() {
//        System.out.println("UserDaoImpl创建。。。");
//    }
//
//    public void init(){
//        System.out.println("init()...");
//    }
//
//    public void destroy(){
//        System.out.println("destroy()...");
//    }

    @Override
    public void save() {
        System.out.println("running save()...");
//        System.out.println(username + ":" + age);
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
    }
}
