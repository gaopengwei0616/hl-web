package com.eda.controller;

import com.eda.dao.CategoryMapper;
import com.eda.pojo.Category;
import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Panda on 2019-10-14.
 */
@Controller
public class ZtzlController {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/ztzl")
    public ModelAndView ztzl(@RequestParam("parentid") Integer parentid, @RequestParam("name") String name,
                             @RequestParam(name="siteid",required = false) Integer siteid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ztzl");


        List<Category> categoryList=categoryMapper.selectZtzl(1120);
        List<News> newsList=newsService.selectZtzlAndLimit(2);

        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("newsList",newsList);
        return modelAndView;
    }

    @RequestMapping("/ztzl2")
    public ModelAndView ztzl2(@RequestParam("catid")Integer catid,@RequestParam("name")String name,
                              @RequestParam(name="siteid",required = false) Integer siteid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ztzl2");


        List<Category> categoryList=categoryMapper.selectZtzl2(catid);
        List<News> newsList=newsService.selectZtzlAndLimit(catid);

        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("newsList",newsList);
        modelAndView.addObject("name",name);
        modelAndView.addObject("siteid2",siteid);
        return modelAndView;
    }


}
