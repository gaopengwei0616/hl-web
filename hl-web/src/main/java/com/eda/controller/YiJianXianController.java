package com.eda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eda.pojo.Complaint;
import com.eda.service.NewsService;

@Controller
public class YiJianXianController {
	 @Autowired
	    private NewsService newsService;
	 
	@RequestMapping("/yjx")
	 private ModelAndView yijianxian(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/yjx");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	@RequestMapping("/yj")
	 private ModelAndView yj(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/yj");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	@RequestMapping("/yijian")
	 private ModelAndView yijian(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/yijian");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	@PostMapping("/yjform")
	 private ModelAndView yjform(@RequestParam("name")String name,
			 @RequestParam("unit")String unit,
			 @RequestParam("address")String address,
			 @RequestParam("phone")String phone,
			 @RequestParam("email")String email,
			 @RequestParam("title")String title,
			 @RequestParam("content")String content
			 
	 ) {
		 ModelAndView model=new ModelAndView();
		 Complaint com=new Complaint();
		 com.setName(name);
		 com.setUnit(unit);
		 com.setAddress(address);
		 com.setPhone(phone);
		 com.setEmail(email);
		 com.setTitle(title);
		 com.setContent(content);
		 com.setStatus("0");
		 com.setYjstatus("1");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 com.setInputtime(sdf.format(new Date()));
		 int count =newsService.insertcomplaint(com);
		 model.setViewName("/yijianxiang/yijian");
		 model.addObject("count", count);
		 return model;
	 }
	
	@RequestMapping("/ts")
	 private ModelAndView ts(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/ts");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	
	@RequestMapping("/toushu")
	 private ModelAndView toushu(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/toushu");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	@PostMapping("/tsform")
	 private ModelAndView tsform(@RequestParam("name")String name,
			 @RequestParam("identity_card")String identity_card,
			 @RequestParam("unit")String unit,
			 @RequestParam("address")String address,
			 @RequestParam("postcode")String postcode,
			 @RequestParam("phone")String phone,
			 @RequestParam("email")String email,
			 @RequestParam("title")String title,
			 @RequestParam("content")String content
			 
	 ) {
		 ModelAndView model=new ModelAndView();
		 Complaint com=new Complaint();
		 com.setName(name);
		 com.setIdentity_card(identity_card);
		 com.setUnit(unit);
		 com.setAddress(address);
		 com.setPostcode(postcode);
		 com.setPhone(phone);
		 com.setEmail(email);
		 com.setTitle(title);
		 com.setContent(content);
		 com.setStatus("1");
		 com.setYjstatus("1");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 com.setInputtime(sdf.format(new Date()));
		 int count =newsService.insertcomplaint(com);
		 model.setViewName("/yijianxiang/toushu");
		 model.addObject("count", count);
		 return model;
	 }
	
	@RequestMapping("/ckjy")
	 private ModelAndView ckjy(@RequestParam("siteid")Integer siteid) {
		 ModelAndView model=new ModelAndView();
		 List<Complaint> com=newsService.selectyijian();
		 model.setViewName("/yijianxiang/ckjy");
		 model.addObject("siteid", siteid);
		 model.addObject("com", com);
		 return model;
	 }
	
	@RequestMapping("/jbbl")
	 private ModelAndView jbbl(@RequestParam("siteid")Integer siteid){
		 ModelAndView model=new ModelAndView();
		 model.setViewName("/yijianxiang/jbbl");
		 model.addObject("siteid", siteid);
		 return model;
	 }
	
	
}
