package com.yida.controller;

import com.yida.mapper.RoleDaoMapper;
import com.yida.service.AdministerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yeke on 2019/7/2.
 */
@Controller
public class IndexController {

    @Autowired
    private AdministerService administerService;
    @Autowired
    private RoleDaoMapper roleDaoMapper;

    @RequestMapping("/")
    public ModelAndView login(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MyPanel");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("sitename",authentication.getName());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }


    //跳转我的面板
    @RequestMapping("/MyPanel")
    public ModelAndView MyPanel(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MyPanel");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }

    //跳转设置
    @RequestMapping("/Setting")
    public ModelAndView Setting(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Setting");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }

    //跳转模块
    @RequestMapping("/Module")
    public ModelAndView Module(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Module");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }
    //跳转内容
    @RequestMapping("/Content")
    public ModelAndView Content(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Content");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }
    //跳转扩展
    @RequestMapping("/Expansion")
    public ModelAndView Expansion(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Expansion");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        modelAndView.addObject("siteid",siteByRoleId);
        return modelAndView;
    }

}
