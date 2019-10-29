package com.yida.service;

import com.yida.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/18.
 */
public interface RoleManagerService {

    Map<String,Object> roleManagerList();

    SysRole findRoleById(Integer roleid);

    Integer deleteRoleById(Integer roleid);

    Integer insertRole(String rolename,String description, Integer listorder,Integer disabled);


    Integer updateRole(String rolename,String description, Integer listorder,Integer disabled,Integer roleid);

    List<SysRole> roleList();
}
