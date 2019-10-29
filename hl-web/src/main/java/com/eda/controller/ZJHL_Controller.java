package com.eda.controller;

import com.eda.pojo.News;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

/**
 * Created by YD on 2019/8/20.
 */
@Controller
public class ZJHL_Controller {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/zouJinHuiLai")
    public ModelAndView zhengWuGongKia(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/zjhl");
        modelAndView.addObject("siteid",siteid);
        return modelAndView;
    }

    @RequestMapping("/zjhlButton")
    public ModelAndView button(@RequestParam("catid") Integer catid,@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        List<News> list = newsService.selectTitleByCid(catid);
        modelAndView.addObject("siteid",siteid);
        modelAndView.setViewName("/zjhlxx");
        modelAndView.addObject("newsList",list);
        return modelAndView;
    }

    @RequestMapping("/zjhlButton1")
    public ModelAndView button1(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("siteid",siteid);
        modelAndView.setViewName("/dlwz");
        return modelAndView;
    }
    @RequestMapping("/zjhlButton2")
    public ModelAndView button2(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("siteid",siteid);
        modelAndView.setViewName("/hlls");
        return modelAndView;
    }

    //招商动态
    @GetMapping("/investmentDynamics")
    @ResponseBody
    public List<News> investmentDynamics(@RequestParam("siteid")Integer siteid){
        return newsService.selectNewsByCatCode("investmentDynamics",1);
    }

    //旅游信息
    @GetMapping("/travelInformation")
    @ResponseBody
    public List<News> travelInformation(@RequestParam("siteid")Integer siteid){
        return newsService.selectNewsByCatCode("travelInformation",1);
    }

    //政策解读
    @GetMapping("/policyAnalyzing")
    @ResponseBody
    public List<News> policyAnalyzing(@RequestParam("siteid")Integer siteid){
        return newsService.selectNewsByCatCode("policyAnalyzing",1);
    }

}
