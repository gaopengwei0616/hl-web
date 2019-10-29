package com.yida.controller.setting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yida.entity.Admin;
import com.yida.service.AdministerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 管理员管理
 */
@Controller
public class AdministerController {
    @Autowired
    AdministerService administerService;

    //显示管理员管理
    @RequestMapping("/AdminManagerList")
    public ModelAndView AdminManagerList(
            @RequestParam(defaultValue = "10",name = "pageSize")Integer pageSize,//分页数量
            @RequestParam(defaultValue = "0",name = "pageNum")Integer pageNum ){
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object> map = administerService.adminList();
        PageInfo<Admin> page = (PageInfo<Admin>) map.get("adminList");
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/Setting/AdminManager");
        modelAndView.addObject("page",page);
        modelAndView.addObject("pageList",page.getList());
        modelAndView.addObject("value",1);
       return modelAndView;

    }

    //跳转添加修改管理员页面
    @GetMapping("/addEditAdmin")
    public ModelAndView addEditAdmin(@RequestParam(name = "type")String type,
                                         @RequestParam(name = "userId",required = false) Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Setting/AdminManager/add_edit_Admin");
        if(type.equals("edit")){
            Admin admin = administerService.findAdminById(userId);
            modelAndView.addObject("admin",admin);
        }
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    //删除管理员
    @PostMapping("/deleteAdminById")
    @ResponseBody
    public Integer deleteAdminById(@RequestParam(name = "userId")Integer userId){
        return administerService.deleteAdminById(userId);
    }

    //添加管理员
    @PostMapping("/insertAdmin")
    public ModelAndView insertAdmin(@RequestParam(name = "username",defaultValue = "")String username,//用户名
                                   @RequestParam(name = "password",defaultValue = "")String password,//密码
                                   @RequestParam(name = "email",defaultValue = "")String email,//邮箱
                                   @RequestParam(name = "realname",defaultValue = "")String realname,//真实姓名
                                   @RequestParam(name = "roleid",defaultValue = "")Integer roleid//角色iD
    ){
        administerService.insertAdmin(username,password,email,realname,roleid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/AdminManagerList");
        return modelAndView;
    }

    //修改管理员
    @PostMapping("/updateAdmin")
    public ModelAndView updateAdmin(@RequestParam(name = "username",defaultValue = "")String username,//用户名
                                   @RequestParam(name = "password",defaultValue = "")String password,//密码
                                   @RequestParam(name = "email",defaultValue = "")String email,//邮箱
                                   @RequestParam(name = "realname",defaultValue = "")String realname,//真实姓名
                                   @RequestParam(name = "roleid",defaultValue = "")Integer roleid,//角色iD
                                   @RequestParam(name = "userid")Integer userid //用户ID
    ){
        administerService.updateAdmin(username,password,email,realname,roleid,userid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/AdminManagerList");
        return modelAndView;
    }


    //检查用户名是否重复
    @GetMapping("/checkUserName")
    @ResponseBody
    public Integer checkUserName(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "type")String type,
                                 @RequestParam(name = "userid",required = false)Integer userid){
        return administerService.checkUserName(username,type,userid);
    }

    //检查用户密码是否正确
    @PostMapping("/checkPasswordById")
    @ResponseBody
    public Integer checkPasswordById(@RequestParam("id")Integer userid,@RequestParam("password")String password){
        return  administerService.checkPasswordById(userid,password);
    }
}
