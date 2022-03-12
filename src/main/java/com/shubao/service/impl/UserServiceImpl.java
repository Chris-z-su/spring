package com.shubao.service.impl;

import com.shubao.dao.RoleDao;
import com.shubao.dao.UserDao;
import com.shubao.domain.Role;
import com.shubao.domain.User;
import com.shubao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component("userService")
@Service("userService")
//@Scope("prototype") //标注bean的作用范围
@Scope("singleton")
public class UserServiceImpl implements UserService {

//    @Value("${jdbc.driver}")
//    private String driver;

    @Autowired //按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao") //按照id值从容器中进行匹配的，但是此处@Qualifier结合@Autowired一起使用
//    @Resource(name = "userDao") //@Resource相当于@Autowired + @Qualifier
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

//    /**
//     * 通过配置文件的方式注入
//     * @param userDao
//     */
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }

    //    public UserServiceImpl() {
//    }
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save(User user, Long[] roleIds) {
//        System.out.println("start UserServiceImpl.save()...");
//        System.out.println(driver);
        //1.保存user数据
        Long userId = userDao.save(user);
        //2.保存user-role多条数据
        userDao.saveUserRoleRel(userId, roleIds);


//        System.out.println("end UserServiceImpl.save()...");
    }

    @Override
    public List<User> getList() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个user的roles数据
        for (User user : userList) {
            //获取user的id
            Long id = user.getId();
            //将id作为参数，查询当前user id对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void deleteUser(Long userId) {
        //1.删除user-role关系表的数据
        userDao.deleteUserRoleRel(userId);
        //2.删除user表的数据
        userDao.deleteUser(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.findUser(username, password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
