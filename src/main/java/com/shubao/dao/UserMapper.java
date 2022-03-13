package com.shubao.dao;

import com.shubao.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    List<User> findAllForMybatis() throws IOException;

    User findOneForMybatis(int id) throws IOException;

    List<User> findByCondition(User user);

    List<User> findByIds(List<Long> ids);
}