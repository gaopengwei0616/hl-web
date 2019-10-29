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
 * Created by Panda on 2019-09-30.
 */
@Controller
public class MapController {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private NewsService ns;

    @RequestMapping("/map")
    public ModelAndView map(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("map");
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam("parentid") Integer parentid, @RequestParam("name") String name,
                             @RequestParam(name="siteid",required = false) Integer siteid){
        ModelAndView modelAndView=new ModelAndView();

        List<News> news = ns.selectNewsBycatid(parentid);


        List<Category> categories = categoryMapper.selectByParentId(parentid);

        modelAndView.addObject("catList", categories);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("siteid",siteid);
        modelAndView.addObject("name", name);
        modelAndView.addObject("parentid", parentid);

        modelAndView.setViewName("news");
        return modelAndView;
    }

    @RequestMapping("/refresh_list")
    public ModelAndView refresh_list(@RequestParam("parentid") Integer parentid, @RequestParam("name") String name,@RequestParam("catid")Integer catid,
                                         @RequestParam("siteid") Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("news");
        List<News> news = ns.selectNewsBycatid2(catid);
        List<Category> categories = categoryMapper.selectByParentId(parentid);
        modelAndView.addObject("catList", categories);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);
        modelAndView.addObject("parentid", parentid);
        modelAndView.addObject("siteid",siteid);
        return modelAndView;
    }

}
