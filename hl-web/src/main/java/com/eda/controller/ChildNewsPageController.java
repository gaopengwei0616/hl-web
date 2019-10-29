package com.eda.controller;

import com.eda.pojo.Hlxw;
import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YD on 2019/8/19.
 */
@Controller
public class ChildNewsPageController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/childNewsPage")
    public ModelAndView index(@RequestParam(defaultValue = "1", name = "siteid") Integer siteid,
                              @RequestParam(defaultValue = "0", name = "newsId") Integer newsId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jump_page/child_news_page");
        modelAndView.addObject("siteid", siteid);// 首页站点ID
        modelAndView.addObject("newsId", newsId);// 首页站点ID
        return modelAndView;
    }

    @PostMapping("/getChildPageContent")
    @ResponseBody
    public Hlxw getChildPageContent(@RequestParam("newsId") Integer newsid) {
        Hlxw hlxw = newsService.hlxwList(newsid);
        return hlxw;
    }
}
