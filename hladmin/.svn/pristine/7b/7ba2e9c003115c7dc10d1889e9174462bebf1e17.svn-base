package com.yida.dao;

import com.yida.entity.Admin;
import com.yida.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/18.
 */
@Component
public class AdminDao {

    @Autowired
    private AdminMapper adminMapper;

    public List<Admin> adminList(){
        return adminMapper.adminList();
    }

    public Admin findAdminById(Integer userId){
        return adminMapper.findAdminById(userId);
    }

    public Integer deleteAdminById(Integer userId){
        return adminMapper.deleteAdminById(userId);
    }

    public Integer insertAdmin(String username, String password, String email, String realname, Integer roleid){
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setEmail(email);
        admin.setRealname(realname);
        admin.setRoleid(roleid);
        return adminMapper.insertAdmin(admin);
    }

    public Integer updateAdmin(String username, String password, String email, String realname, Integer roleid,Integer userid){
        Admin admin = new Admin();
        admin.setUserid(userid);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setEmail(email);
        admin.setRealname(realname);
        admin.setRoleid(roleid);
        return adminMapper.updateAdmin(admin);
    }

    public Admin  searchAdminByUsername(String username){
       return adminMapper.searchAdminByUsername(username);
    }

    public Integer updateAdminByUsername(Admin admin){
        return adminMapper.updateAdmin(admin);
    }

    public Admin findAdminByName(String username){
        return adminMapper.findAdminByName(username);
    }
}
