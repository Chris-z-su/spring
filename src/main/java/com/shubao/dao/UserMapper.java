package com.shubao.dao;

import com.shubao.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User> findAllForMybatis() throws IOException;
}
