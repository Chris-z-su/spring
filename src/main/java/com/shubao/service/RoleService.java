package com.shubao.service;

import com.shubao.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getList();

    void saveRole(Role role);
}
