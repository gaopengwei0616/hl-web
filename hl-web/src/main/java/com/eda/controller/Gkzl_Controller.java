package com.eda.controller;

import com.eda.dao.CategoryMapper;
import com.eda.pojo.Category;
import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by YD on 2019/8/21.
 */
@Controller
public class Gkzl_Controller {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private NewsService ns;


    @RequestMapping("/gkzl")
    public ModelAndView zdly_category(@RequestParam("parentid") Integer parentid, @RequestParam("name") String name,
                                      @RequestParam(name="siteid",required = false) Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gkzl");


        List<Category> categories = categoryMapper.selectByParentId(parentid);
        List<News> news = ns.selectNewsBycatid2(parentid);

        modelAndView.addObject("catList", categories);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("siteid",siteid);
        modelAndView.addObject("name", name);
        modelAndView.addObject("parentid", parentid);
        return modelAndView;
    }
    @RequestMapping("/refresh_category")
    public ModelAndView refresh_category(@RequestParam("parentid") Integer parentid, @RequestParam("name") String name,@RequestParam("catid")Integer catid,
                                         @RequestParam("siteid") Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gkzl");
        List<News> news = ns.selectNewsBycatid(catid);
        List<Category> categories = categoryMapper.selectByParentId(parentid);
        modelAndView.addObject("catList", categories);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);
        modelAndView.addObject("parentid", parentid);
        modelAndView.addObject("siteid",siteid);
        return modelAndView;
    }

    @GetMapping("/zwgkList")
    @ResponseBody
    public List<Category> zhongdianlingyuList(){
        return categoryMapper.selectAllByParentId99();
    }

}
