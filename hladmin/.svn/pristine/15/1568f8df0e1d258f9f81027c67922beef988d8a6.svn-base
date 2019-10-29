package com.yida.dao;

import com.yida.entity.SysRole;
import com.yida.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/7/18.
 */
@Component
public class RoleDao {

    @Autowired
    private RoleMapper roleMapper;

    public List<SysRole> roleList(){
        return roleMapper.findRole();
    }

    public SysRole findRoleById(Integer roleid){
        return roleMapper.findRoleById(roleid);
    }

    public Integer deleteRoleById(Integer roleid){
        return roleMapper.deleteRoleById(roleid);
    }

    public Integer insertRole(String rolename, String description, Integer listorder, Integer disabled ){
        SysRole role = new SysRole();
        role.setRolename(rolename);
        role.setDescription(description);
        return roleMapper.insertRole(role);
    }

    public Integer updateRole(String rolename, String description, Integer listorder, Integer disabled,Integer roleid ){
        SysRole role = new SysRole();
        role.setRoleid(roleid);
        role.setRolename(rolename);
        role.setDescription(description);
        return roleMapper.updateRole(role);
    }
}
