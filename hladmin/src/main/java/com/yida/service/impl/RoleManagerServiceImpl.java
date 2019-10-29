package com.yida.service.impl;

import com.github.pagehelper.PageInfo;
import com.yida.dao.RoleDao;
import com.yida.entity.Admin;
import com.yida.entity.SysRole;
import com.yida.service.RoleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/18.
 */
@Service
public class RoleManagerServiceImpl implements RoleManagerService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map<String, Object> roleManagerList() {
        Map<String,Object> map = new HashMap<>();
        List<SysRole> roleList = roleDao.roleList();
        PageInfo<SysRole> page = new PageInfo<SysRole>(roleList);
        map.put("roleList",page);
        return map;

    }

    @Override
    public SysRole findRoleById(Integer roleid) {
        return roleDao.findRoleById(roleid);
    }

    @Override
    public Integer deleteRoleById(Integer roleid) {
        return roleDao.deleteRoleById(roleid);
    }

    @Override
    public Integer insertRole(String rolename, String description, Integer listorder, Integer disabled) {
        return roleDao.insertRole(rolename,description,listorder,disabled);
    }

    @Override
    public Integer updateRole(String rolename, String description, Integer listorder, Integer disabled, Integer roleid) {
        return roleDao.updateRole(rolename,description,listorder,disabled,roleid);
    }

    @Override
    public List<SysRole> roleList() {
        return roleDao.roleList();
    }
}
