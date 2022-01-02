package com.shubao.factory;

import com.shubao.dao.UserDao;
import com.shubao.dao.impl.UserDaoImpl;

/**
 * 静态工厂
 */
public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
