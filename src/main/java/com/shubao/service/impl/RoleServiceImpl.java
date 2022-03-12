package com.shubao.service.impl;

import com.shubao.dao.RoleDao;
import com.shubao.domain.Role;
import com.shubao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

//    public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }

    @Override
    public List<Role> getList() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void saveRole(Role role) {
        roleDao.save(role);
    }
}
