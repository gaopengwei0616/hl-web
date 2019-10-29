package com.yida.controller.setting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yida.entity.Site;
import com.yida.entity.SysRole;
import com.yida.service.RoleManagerService;
import com.yida.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by yk on 2019/7/18.
 * 角色管理
 */
@Controller
public class RoleManagerController {

    @Autowired
    private RoleManagerService roleManagerService;
    @Autowired
    private SiteService siteService;

    //跳转管理页面
    @RequestMapping("/RoleManagerList")
    public ModelAndView RoleManagerList(
            @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,//分页数量
            @RequestParam(defaultValue = "0", name = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = roleManagerService.roleManagerList();
        PageInfo<SysRole> page = (PageInfo<SysRole>) map.get("roleList");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Setting/RoleManager");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageList", page.getList());
        modelAndView.addObject("value", 1);
        return modelAndView;

    }

    //跳转添加修改页面
    @GetMapping("/addEditRole")
    public ModelAndView addEditPrlePoint(@RequestParam(name = "type") String type,
                                         @RequestParam(name = "roleid", required = false) Integer roleid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Setting/RoleManager/add_edit_Role");
        if (type.equals("edit")) {
            SysRole role = roleManagerService.findRoleById(roleid);
            modelAndView.addObject("role", role);
        }
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    //删除角色
    @PostMapping("/deleteRoleById")
    @ResponseBody
    public Integer deleteRoleById(@RequestParam(name = "roleid") Integer roleid) {
        return roleManagerService.deleteRoleById(roleid);
    }

    //添加角色
    @PostMapping("/insertRole")
    public ModelAndView insertSite(@RequestParam(name = "rolename", defaultValue = "") String rolename,//角色名称
                                   @RequestParam(name = "description", defaultValue = "") String description,//描述
                                   @RequestParam(name = "listorder", defaultValue = "") Integer listorder,//排序
                                   @RequestParam(name = "disabled", defaultValue = "") Integer disabled//可用
    ) {
        roleManagerService.insertRole(rolename, description, listorder, disabled);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/RoleManagerList");
        return modelAndView;
    }

    //修改角色
    @PostMapping("/updateRole")
    public ModelAndView insertSite(@RequestParam(name = "rolename", defaultValue = "") String rolename,//角色名称
                                   @RequestParam(name = "description", defaultValue = "") String description,//描述
                                   @RequestParam(name = "listorder", defaultValue = "") Integer listorder,//排序
                                   @RequestParam(name = "disabled", defaultValue = "") Integer disabled,//可用
                                   @RequestParam(name = "roleid") Integer roleid //角色ID
    ) {
        roleManagerService.updateRole(rolename, description, listorder, disabled, roleid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/RoleManagerList");
        return modelAndView;
    }

    //角色列表
    @GetMapping("/roleList")
    @ResponseBody
    public List<SysRole> catParentDirList() {
        List<SysRole> roleList = roleManagerService.roleList();
        return roleList;
    }

    //角色列表权限
    @RequestMapping("/Purviewseting")
    public String purviewseting() {
        return "/Setting/RoleManager/purviewsetting";
    }

    @GetMapping("/getSites")
    @ResponseBody
    public List<Site> getSites() {
        List<Site> sites = siteService.GetSiteList();
        return sites;
    }

}

