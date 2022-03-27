package com.shubao.mapper;

import com.shubao.domain.User;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAllForMybatis() throws IOException;

    User findOneForMybatis(int id) throws IOException;

    List<User> findByCondition(User user);

    List<User> findByIds(List<Long> ids);

    public void save(User user);

    public User findByid(int id);

    List<User> findAll();

    List<User> findUserAndRole();

}
