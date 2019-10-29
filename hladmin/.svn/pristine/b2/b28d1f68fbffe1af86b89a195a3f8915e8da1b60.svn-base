package com.yida.service;

import com.yida.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * 管理员数据管理
 */
public interface AdministerService {

    Map<String,Object> adminList();

    Admin findAdminById(Integer userId);

    int deleteAdminById(Integer userId);

    int insertAdmin(String username,String password,String email,String realname,Integer roleid);

    Integer updateAdmin(String username,String password,String email,String realname,Integer roleid,Integer userid);

    Integer checkUserName(String username,String type,Integer userid);

    Integer updateAdminByName(Admin admin);

    Admin findAdminByName(String username);

    Integer checkPassword(String username,String password);

    Integer checkPasswordById(Integer userid,String password);
}
