package com.shubao.factory;

import com.shubao.dao.UserDao;
import com.shubao.dao.impl.UserDaoImpl;

/**
 * 实例工厂
 */
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
