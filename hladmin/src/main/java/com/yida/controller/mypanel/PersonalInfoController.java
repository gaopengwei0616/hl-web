package com.yida.controller.mypanel;

import com.yida.entity.Admin;
import com.yida.entity.SysRole;
import com.yida.service.AdministerService;
import com.yida.service.RoleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yk on 2019/7/17.
 * 个人信息
 */
@Controller
public class PersonalInfoController {

    @Autowired
    private AdministerService administerService;

    @Autowired
    private RoleManagerService roleManagerService;

    //跳转修改个人信息页面
    @RequestMapping("/EditPersonalInfo")
    public String EditPersonalInfo() {
        return "/MyPanel/EditPersonalInfo";
    }

    //跳转我的个人信息页面
    @RequestMapping("/MyPersonalInfo")
    public String MyPersonalInfo() {
        return "/MyPanel/MyPersonalInfo";
    }

    //跳转修改密码页面
    @RequestMapping("/EditAdminPassword")
    public String EditAdminPassword() {
        return "/MyPanel/EditAdminPassword";
    }

    //获取security登录用户
    @RequestMapping("/me/Authentication")
    @ResponseBody
    public Authentication getCurrentUser(Authentication authentication){
        return authentication;
    }

    //通过用户名获取当前用户信息
    @RequestMapping("/searchUserInfo")
    @ResponseBody
    public Admin getUserInfo(@RequestParam("username")String username){
        return administerService.findAdminByName(username);
    }

    //通过角色id获取当前角色信息
    @RequestMapping("/searchRoleById")
    @ResponseBody
    public SysRole getRoleInfo(@RequestParam("roleid")Integer roleid){
        return roleManagerService.findRoleById(roleid);
    }

    //from表单修改用户信息
    @PostMapping("/updateUserInfo")
    public ModelAndView updateUserInfo(Authentication authentication,
                                       @RequestParam(name = "realname")String realname,
                                       @RequestParam(name = "email")String email){
        ModelAndView modelAndView = new ModelAndView();
        Admin adminByName = administerService.findAdminByName(authentication.getName());
//        adminByName.setLastlogintime();
        adminByName.setRealname(realname);
        adminByName.setEmail(email);
        administerService.updateAdminByName(adminByName);
        modelAndView.setViewName("redirect:/EditPersonalInfo");
        return modelAndView;
    }

    //form表单修改用户密码
    @PostMapping("/updatePassword")
    @ResponseBody
    public Integer updatePassword(Authentication authentication,
                                  @RequestParam(name = "new_password")String newPassword){
        Admin adminByName = administerService.findAdminByName(authentication.getName());
        adminByName.setPassword(newPassword);
        return administerService.updateAdminByName(adminByName);
    }

    //检查用户密码是否正确
    @PostMapping("/checkPassword")
    @ResponseBody
    public Integer checkPassword(@RequestParam("password")String password,Authentication authentication){
        String username = authentication.getName();
        return  administerService.checkPassword(username,password);
    }
}
