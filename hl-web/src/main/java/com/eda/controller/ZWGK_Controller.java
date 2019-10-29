package com.eda.controller;

import com.eda.dao.SiteMapper;
import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by YD on 2019/8/20.
 */
@Controller
public class ZWGK_Controller {

    @Autowired
    private NewsService newsService;

    @Autowired
    private  SiteMapper siteMapper;

    @RequestMapping("/zhengWuGongKai")
    public ModelAndView zhengWuGongKai(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/zwgk");
        modelAndView.addObject("siteid",siteid);
        Integer type = siteMapper.findSiteById(siteid).getType();
        modelAndView.addObject("type",type);
        return modelAndView;
    }


    @GetMapping("/getDongTaiList")
    @ResponseBody
    public List<News> getDongTaiList(@RequestParam("siteid")Integer siteid){
        return newsService.selectNewsByCatCode2("announcement", 1, 9);
    }

    @RequestMapping("/zwgkbottom")
    private ModelAndView zwgkdb(@RequestParam("siteid")Integer siteid) {
        ModelAndView model=new ModelAndView();
        model.setViewName("/page/zwgk_db");
        model.addObject("siteid", siteid);
        return model;
    }



}
