package com.shubao.dao;

import com.shubao.domain.User;

import java.util.List;

public interface UserDao {

    Long save(User user);

    List<User> findAll();

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void deleteUserRoleRel(Long userId);

    void deleteUser(Long userId);

    User findUser(String username, String password);
}
