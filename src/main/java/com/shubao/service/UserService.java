package com.shubao.service;

import com.shubao.domain.User;

import java.util.List;

public interface UserService {

    void save(User user, Long[] roleIds);

    List<User> getList();

    void deleteUser(Long userId);
}
