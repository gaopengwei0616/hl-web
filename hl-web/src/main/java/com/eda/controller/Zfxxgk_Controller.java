package com.eda.controller;

import com.eda.dao.CategoryMapper;
import com.eda.dao.NewsMapper;
import com.eda.dao.SiteMapper;
import com.eda.pojo.Category;
import com.eda.pojo.News;
import com.eda.pojo.Site;
import com.eda.service.NewsService;
import com.eda.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YD on 2019/8/21.
 */
@Controller
public class Zfxxgk_Controller {

    @Autowired
    private SiteMapper sm;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private NewsMapper ns;
    @Autowired
    private TableService tableService;

    @RequestMapping("/zfxxgk")
    public ModelAndView zfxxgk(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zfxxgk");
        List<Site> zfList=sm.selectSite(2);
        List<Site> jdList=sm.selectSite(1);
        modelAndView.addObject("zf",zfList);
        modelAndView.addObject("jd",jdList);
        modelAndView.addObject("siteid2",1);
        
        return modelAndView;
    }

    @RequestMapping("/zfxxgk2")
    public ModelAndView zfxxgk2(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zfxxgk2");
        List<Site> zfList=sm.selectSite(2);
        List<Site> jdList=sm.selectSite(1);
        modelAndView.addObject("zf",zfList);
        modelAndView.addObject("jd",jdList);
        modelAndView.addObject("siteid2",1);

        return modelAndView;
    }

    @RequestMapping("/zfxxgk_details")
    public ModelAndView zfxxgk_details(@RequestParam("name")String name,@RequestParam("siteid")Integer siteid,@RequestParam("catid")Integer catid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zfxxgk_details");
        modelAndView.addObject("name2", name);
        modelAndView.addObject("siteid2",siteid);
        List<Category> catList=categoryMapper.selectCategoryByCode("governmentColumn", siteid);


        int catid2=categoryMapper.selectCatid(siteid);


        List<News> news = ns.selectNewsBycatid(catid2);


        modelAndView.addObject("categoryList",catList);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @RequestMapping("/zfxxgk_details2")
    public ModelAndView zfxxgk_details2(@RequestParam("name")String name,@RequestParam("siteid")Integer siteid,@RequestParam("catid")Integer catid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zfxxgk_details");
        modelAndView.addObject("name2", name);
        modelAndView.addObject("siteid2",siteid);
        List<Category> catList=categoryMapper.selectCategoryByCode("governmentColumn", siteid);


        List list=new ArrayList();
        for(Category c:catList){
            list.add(c.getCatid());
        }

        List<News> news = ns.selectByCatids(list);


        modelAndView.addObject("categoryList",catList);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @RequestMapping("/zfxxgk_details_refresh")
    public ModelAndView zfxxgk_details_refresh(@RequestParam("name")String name,@RequestParam("siteid")Integer siteid,@RequestParam("catid")Integer catid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zfxxgk_details");
        modelAndView.addObject("name2", name);
        modelAndView.addObject("siteid2",siteid);
        List<Category> catList=categoryMapper.selectCategoryByCode("governmentColumn", siteid);
        List<News> news = ns.selectNewsBycatid(catid);
        modelAndView.addObject("categoryList",catList);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @RequestMapping("ysqgklc")
    public ModelAndView ysqgklc(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgklc");
        modelAndView.addObject("siteid", siteid);
        return modelAndView;
    }
    
    @RequestMapping("/xiazaiziliao_zf")
    public ModelAndView xiazaiziliao_zf(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("xiazaiziliao_zf");
        List<Site> zfList=sm.selectSite(2);
        List<Site> jdList=sm.selectSite(1);
        modelAndView.addObject("zf",zfList);
        modelAndView.addObject("jd",jdList);
        modelAndView.addObject("siteid2",1);
        
        return modelAndView;
    }
    @RequestMapping("/xiazaiziliao_details")
    public ModelAndView xiazaiziliao_details(@RequestParam("name")String name,@RequestParam("siteid")Integer siteid){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("xiazaiziliao");
        modelAndView.addObject("name2", name);
        modelAndView.addObject("siteid2",siteid);
        
        List<Category> catList=categoryMapper.selectCategoryByXzzl(siteid);
        Integer catid = categoryMapper.selectCategoryForId(siteid);
        List<News> news = ns.selectNewsBycatid(catid);
        modelAndView.addObject("categoryList",catList);
        modelAndView.addObject("newList",news);
        modelAndView.addObject("name", name);

        return modelAndView;
    }


    /*
     *依申请公开
     */
    @RequestMapping("/ysqgk")
    public ModelAndView ysqgk(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk");
        List<Site> zfList=sm.selectSite(2);
        List<Site> jdList=sm.selectSite(1);
        modelAndView.addObject("zf",zfList);
        modelAndView.addObject("jd",jdList);
        modelAndView.addObject("siteid2",1);

        return modelAndView;
    }

    @RequestMapping("/ysqgk_details")
    public ModelAndView ysqgk_details(int siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("siteid2",siteid);
        modelAndView.setViewName("ysqgk_details");

        return modelAndView;
    }

    @RequestMapping("/ysqgk_check")
    public ModelAndView ysqgk_check(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_check");

        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq")
    public ModelAndView ysqgk_sq(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq");

        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details")
    public ModelAndView ysqgk_sq_details(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_gm")
    public ModelAndView ysqgk_sq_details_gm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details_gm");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_jg")
    public ModelAndView ysqgk_sq_details_jg(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details_jg");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_fr")
    public ModelAndView ysqgk_sq_details_fr(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details_fr");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_st")
    public ModelAndView ysqgk_sq_details_st(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details_st");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_qita")
    public ModelAndView ysqgk_sq_details_qita(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ysqgk_sq_details_qita");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_gm_sq")
    public ModelAndView ysqgk_sq_details_gm_sq(@RequestParam("name")String name,@RequestParam("workUnit")String workUnit,
                                       @RequestParam("idCard")String idCard,@RequestParam("postalCode")String postalCode,
                                       @RequestParam("address")String address,@RequestParam("telephone")String telephone,
                                       @RequestParam("phone")String phone,@RequestParam("mail")String mail,
                                       @RequestParam("fileName")String fileName,@RequestParam("fileNumber")Integer fileNumber,
                                       @RequestParam("description")String description,@RequestParam("postWay")String postWay,
                                       @RequestParam("getWay")String getWay,@RequestParam(value = "status",defaultValue = "未通过",required =false)String status, @RequestParam("number")Integer number){
        Integer num = tableService.insertGmsq(name, workUnit, idCard, postalCode, address, telephone, phone, mail, fileName, fileNumber, description, postWay, getWay,status,number);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("num",num);
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    @RequestMapping("/ysqgk_sq_details_qt_sq")
    public ModelAndView ysqgk_sq_details_qt_sq(@RequestParam("name")String name, @RequestParam("address")String address,
                                               @RequestParam("code")String code, @RequestParam("businessLicens")String businessLicens,
                                               @RequestParam("legalPerson")String legalPerson, @RequestParam("personCard")String personCard,
                                               @RequestParam("contacts")String contacts, @RequestParam("contactsTelephone")String contactsTelephone,
                                               @RequestParam("contactsPhone")String contactsPhone, @RequestParam("contactsMail")String contactsMail,
                                               @RequestParam("fileName")String fileName, @RequestParam("fileNumber")String fileNumber,
                                               @RequestParam("description")String description, @RequestParam("postWay")String postWay,
                                               @RequestParam("getWay")String getWay, @RequestParam("type")String type,
                                               @RequestParam(value = "status",defaultValue = "未通过",required =false)String status,
                                               @RequestParam("number")Integer number){
        Integer num = tableService.insertOtherTable(name, address, code, businessLicens, legalPerson, personCard, contacts, contactsTelephone, contactsPhone, contactsMail, fileName, fileNumber, description, postWay, getWay, type,status,number);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("num",num);
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
