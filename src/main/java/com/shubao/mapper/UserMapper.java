package com.shubao.mapper;

import com.shubao.domain.User;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAllForMybatis() throws IOException;

    @Select("select * from sys_user where id = #{id}")
    User findOneForMybatis(int id) throws IOException;

    List<User> findByCondition(User user);

    List<User> findByIds(List<Long> ids);

    @Insert("insert into sys_user values(#{id}, #{username}, #{email}, #{password}, #{phoneNum}, #{birthday})")
    public void save(User user);

    public User findByid(int id);

    List<User> findAll();

    List<User> findUserAndRole();

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.shubao.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();


    @Select("SELECT * FROM sys_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "roles",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.shubao.mapper.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRoleAll();

}
