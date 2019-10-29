package com.yida.controller.setting;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yida.entity.Site;
import com.yida.service.SiteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by rishun on 2019/7/10.
 * 站点管理
 */
@Controller
public class SiteManagementController {
    @Autowired
    SiteService siteService;

    //站点管理数据
    @GetMapping("/SiteManagementList")
    @ResponseBody
    public ModelAndView SiteManagement(@RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
                                   @RequestParam(defaultValue = "0", name = "pageNum", required = false) Integer pageNum
    ) {
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(pageNum, pageSize);
        List<Site> siteList = siteService.GetSiteList();
        PageInfo<Site> page = new PageInfo<Site>(siteList);
        modelAndView.setViewName("/Setting/SiteManagement");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageList", page.getList());
        modelAndView.addObject("value", 1);
        return modelAndView;
    }

    //跳转添加修改站点页面
    @RequestMapping("/addEditSite")
    public ModelAndView addEditSite(@RequestParam(name = "type")String type,
                                    @RequestParam(name = "siteId",required = false)Integer siteId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Setting/SiteManager/add_edit_site");
        if(type.equals("edit")){
            Site site = siteService.SiteBysiteId(siteId);
            modelAndView.addObject("site",site);
        }
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    //删除站点
    @PostMapping("/deleteSiteById")
    @ResponseBody
    public Integer deleteSiteById(@RequestParam(name = "siteId")Integer siteId){
        return siteService.updateBysiteId(siteId,0);
    }

    //添加站点
    @PostMapping("/insertSite")
    public ModelAndView insertSite(@RequestParam(name = "name",defaultValue = "")String name,//站点名称
                              @RequestParam(name = "dirname",defaultValue = "")String dirname,//站点目录
                              @RequestParam(name = "domain",defaultValue = "")String domain,//站点域名
                              @RequestParam(name = "site_title",defaultValue = "")String site_title,//站点标题
                              @RequestParam(name = "keywords",defaultValue = "")String keywords,//关键词
                              @RequestParam(name = "description",defaultValue = "")String description,//描述
                              @RequestParam(name = "release_point",defaultValue = "")String release_point,//发布点
                              @RequestParam(name = "siteType",defaultValue = "")Integer siteType//站点类型
    ){
        siteService.insertSite(name,dirname,domain,site_title,keywords,description,release_point,siteType);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/SiteManagementList");
        return modelAndView;
    }

    //修改站点
    @PostMapping("/updateSite")
    public ModelAndView insertSite(@RequestParam(name = "siteid",defaultValue = "")Integer siteid,//站点ID
                                   @RequestParam(name = "name",defaultValue = "")String name,//站点名称
                                   @RequestParam(name = "dirname",defaultValue = "")String dirname,//站点目录
                                   @RequestParam(name = "domain",defaultValue = "")String domain,//站点域名
                                   @RequestParam(name = "site_title",defaultValue = "")String site_title,//站点标题
                                   @RequestParam(name = "keywords",defaultValue = "")String keywords,//关键词
                                   @RequestParam(name = "description",defaultValue = "")String description,//描述
                                   @RequestParam(name = "release_point",defaultValue = "")String release_point,//发布点
                                   @RequestParam(name = "siteType",defaultValue = "")Integer siteType//站点类型
    ){
        siteService.updateSite(siteid,name,dirname,domain,site_title,keywords,description,release_point,siteType);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/SiteManagementList");
        return modelAndView;
    }
}
