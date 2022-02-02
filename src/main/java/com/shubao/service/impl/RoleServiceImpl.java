package com.shubao.service.impl;

import com.shubao.dao.RoleDao;
import com.shubao.domain.Role;
import com.shubao.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getList() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }
}
