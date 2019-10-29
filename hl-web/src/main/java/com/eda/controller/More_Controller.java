package com.eda.controller;

import com.eda.dao.SiteMapper;
import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YD on 2019/8/21.
 */
@Controller
public class More_Controller {

    @Autowired
    private SiteMapper siteMapper;
    @Autowired
    private NewsService newsService;

    @RequestMapping("/more")
    public ModelAndView more(@RequestParam("siteid") Integer siteid,
                             @RequestParam("catCode")String catCode,
                             @RequestParam("name")String name,
                             @RequestParam("flag")String flag){
        ModelAndView modelAndView = new ModelAndView("/more");
        modelAndView.addObject("siteid",siteid);
        Integer type = siteMapper.findSiteById(siteid).getType();
        modelAndView.addObject("type",type);
        List<News> dataList = new ArrayList<>();
        if(flag.equals("no")){
           dataList = newsService.selectNewsByCatCode(catCode, 1);
        }
        if(flag.equals("yes")){
           dataList = newsService.selectNewsByCatCode(catCode, siteid);
        }
        modelAndView.addObject("dataList",dataList);
        modelAndView.addObject("name",name);
        return modelAndView;
    }


    @RequestMapping("/more2")
    public ModelAndView more2(@RequestParam("siteid") Integer siteid,
                             @RequestParam("catid")Integer catid,
                             @RequestParam("name")String name){
        ModelAndView modelAndView = new ModelAndView("/more");
        modelAndView.addObject("siteid",siteid);
        Integer type = siteMapper.findSiteById(siteid).getType();
        modelAndView.addObject("type",type);
        List<News> dataList = new ArrayList<>();
        dataList = newsService.selectNewsBycatId(catid, siteid);
        modelAndView.addObject("dataList",dataList);
        modelAndView.addObject("name",name);
        return modelAndView;
    }
}
