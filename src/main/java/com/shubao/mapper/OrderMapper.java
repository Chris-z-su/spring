package com.shubao.mapper;

import com.shubao.domain.Order;
import com.shubao.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

//    @Select("select *, o.id oid from sys_order o, sys_user u where o.uid = u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "email", property = "user.email"),
//            @Result(column = "password", property = "user.password"),
//            @Result(column = "phoneNum", property = "user.phoneNum"),
//            @Result(column = "birthday", property = "user.birthday")
//
//    })
//    public List<Order> findAll();

    @Select("select * from sys_order o, sys_user u where o.uid = u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",  //要封装的属性名
                    column = "uid",  //根据哪个字段查询user表的数据
                    javaType = User.class,  //要封装的实体类型
                    //select属性，代表查询哪个接口的方法获得数据
                    one = @One(select = "com.shubao.mapper.UserMapper.findOneForMybatis")
            )

    })
    public List<Order> findAll();

    @Select("select * from sys_order where uid = #{uid}")
    public List<Order> findByUid(int uid);

}
