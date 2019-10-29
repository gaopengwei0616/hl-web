package com.eda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eda.pojo.News;
import com.eda.service.NewsService;

@Controller
public class FileSearchController {
  @Autowired
  private NewsService newsService;
  
  @RequestMapping("/searchfile")
  public ModelAndView searchfile(@RequestParam(defaultValue = "", required =false ,name = "title") String title,
		  @RequestParam(defaultValue = "", required =false ,name = "siteid") String siteid) {
	  List<News> news=newsService.searchNew(title);
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("/fileSearch/search");
      modelAndView.addObject("news", news);
      modelAndView.addObject("siteid", siteid);
	  return modelAndView;
  }
  
  @RequestMapping("/newscontenmt")
  public ModelAndView newscontenmt(@RequestParam(defaultValue = "", required =false ,name = "newsid") Integer newsid,
		  @RequestParam(defaultValue = "", required =false ,name = "siteid") String siteid) {
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("/fileSearch/child_news_page");
     modelAndView.addObject("newsid", newsid);
     modelAndView.addObject("siteid", siteid);
	  return modelAndView;
  }
}
