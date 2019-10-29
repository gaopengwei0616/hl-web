package com.yida.mapper;

import com.yida.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<SysRole> findRole();

    SysRole findRoleById(@Param("roleid") Integer roleid);
    Integer deleteRoleById(@Param("roleid") Integer roleid);

    Integer insertRole(SysRole role);

    Integer updateRole(SysRole role);
}
