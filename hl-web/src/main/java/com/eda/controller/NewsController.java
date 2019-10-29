package com.eda.controller;

import com.eda.dao.CategoryMapper;
import com.eda.dao.SiteMapper;
import com.eda.pojo.Category;
import com.eda.pojo.News;
import com.eda.pojo.Pic;
import com.eda.pojo.Site;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YD on 2019/8/16.
 */
@Controller
public class NewsController {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public ModelAndView defaultIndex(@RequestParam(defaultValue = "1", name = "siteid") Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("siteid", siteid);// 首页站点ID
        Integer type = siteMapper.findSiteById(siteid).getType();
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(defaultValue = "1", name = "siteid") Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("siteid", siteid);// 首页站点ID
        Integer type = siteMapper.findSiteById(siteid).getType();
        modelAndView.addObject("type",type);
        return modelAndView;
    }
    //→_→轮播图
    @PostMapping("/index/rightPicList")
    @ResponseBody
    public Map<String, Object> rightPicList(@RequestParam(name = "siteid") Integer siteid) {
        List<News> hl_news = newsService.selectNewsByCatCode("hl_news", siteid);
        List<News> gnw_news = newsService.selectNewsByCatCode("gnw_news", siteid);
        List<News> zscd_news = newsService.selectNewsByCatCode("zscd_news", siteid);
        Map<String, Object> map = new HashMap<>();
        map.put("hl_news", hl_news);
        map.put("gnw_news", gnw_news);
        map.put("zscd_news", zscd_news);
        return map;
    }
    //镇→_→轮播图
    @PostMapping("/index/rightPicListTo")
    @ResponseBody
    public Map<String, Object> rightPicListToZhen(@RequestParam(name = "siteid") Integer siteid) {
        List<News> workDynamics = newsService.selectNewsByCatCode("workDynamics", siteid);
        List<News> departmentalDocument = newsService.selectNewsByCatCode("departmentalDocument", siteid);
        List<News> townYardSummary = newsService.selectNewsByCatCode("townYardSummary", siteid);
        Map<String, Object> map = new HashMap<>();
        map.put("workDynamics", workDynamics);
        map.put("departmentalDocument", departmentalDocument);
        map.put("townYardSummary", townYardSummary);
        return map;
    }
    //惠来县领导
    @PostMapping("/index/hl_leader")
    @ResponseBody
    public Map<String, Object> hl_leader(@RequestParam(name = "siteid") Integer siteid) {
        Map<String, Object> map = new HashMap<>();
        List<News> leader = newsService.selectNewsByCatCode("leader", siteid);
        List<News> deputy_leader = newsService.selectNewsByCatCode("deputy_leader", siteid);
        map.put("leader", leader);
        map.put("deputy_leader", deputy_leader);
        return map;
    }
    //政府专栏
    @PostMapping("/index/governmentColumn")
    @ResponseBody
    public List<Category> governmentColumn(@RequestParam(name = "siteid") Integer siteid) {
        return categoryMapper.selectCategoryByCode("governmentColumn", siteid);
    }
    //政府信息公开
    @PostMapping("/index/info_disclosure")
    @ResponseBody
    public Map<String, Object> infoDisclosure(@RequestParam(name = "siteid") Integer siteid) {
        Map<String, Object> map = new HashMap<>();
        List<News> infoDisclosure = newsService.selectNewsByCatCode2("infoDisclosure", siteid, 6);
        List<News> importantArea = newsService.selectNewsByCatCode2("importantArea", siteid, 6);
        map.put("infoDisclosure", infoDisclosure);
        map.put("importantArea", importantArea);
        return map;
    }
    //中间轮播图
    @PostMapping("/index/centerPicList")
    @ResponseBody
    public List<Pic> centerPicList(@RequestParam(name = "siteid") Integer siteid) {
        return newsService.selectPics("centerPicList", 1);
    }



    //首页轮播图
    @PostMapping("/index/topPicList")
    @ResponseBody
    public List<Pic> topPicList(@RequestParam(name = "siteid") Integer siteid) {
        return newsService.selectPics("topPicList", 1);
    }

    //←_←轮播图
    @PostMapping("/index/leftPicList")
    @ResponseBody
    public List<Pic> leftPicList(@RequestParam(name = "siteid") Integer siteid) {
        return newsService.selectPics("leftPicList", 1);
    }

    //首页中部轮播
    @PostMapping("/index/midPicList")
    @ResponseBody
    public List<Pic> midPicList(@RequestParam(name = "siteid") Integer siteid) {
        return newsService.selectPics("midPicList", 1);
    }

    //政务服务
    @PostMapping("/index/zwfwService")
    @ResponseBody
    public Map<String, Object> zwfwService(@RequestParam(name = "siteid") Integer siteid) {
        Map<String, Object> map = new HashMap<>();
        List<News> personalService = newsService.selectNewsByCatCode("personalService", 1);
        List<News> corporateService = newsService.selectNewsByCatCode("corporateService", 1);
        map.put("personalService", personalService);
        map.put("corporateService", corporateService);
        return map;
    }

    //中间内容
    @PostMapping("/index/centerContent")
    @ResponseBody
    public Map<String, Object> centerContent(@RequestParam(name = "siteid") Integer siteid) {
        Map<String, Object> map = new HashMap<>();
        List<News> announcement = newsService.selectNewsByCatCode2("announcement", 1, 6);
        List<News> showVideo = newsService.selectNewsByCatCode2("showVideo", 1, 1);
        map.put("announcement", announcement);
        map.put("showVideo", showVideo);
        return map;
    }
    //首页信息公开-重点领域
    @PostMapping("/index/index_disclosure")
    @ResponseBody
    public Map<String, Object> indexDisclosure(@RequestParam(name = "siteid") Integer siteid) {
        Map<String, Object> map = new HashMap<>();
        List<News> infoDisclosure = newsService.selectNewsByCatCode2("infoDisclosure", 1, 6);
        List<News> importantArea = newsService.selectNewsByCatCode2("importantArea", 1, 6);
        List<News> dongtaiList = newsService.selectNewsByCatCode2("dongtaiList", 1, 7);
        map.put("infoDisclosure", infoDisclosure);
        map.put("importantArea", importantArea);
        map.put("dongtaiList", dongtaiList);
        return map;
    }

    @Autowired
    private SiteMapper siteMapper;

    //站点列表
    @GetMapping("/index/siteSelect")
    @ResponseBody
    public List<Site> siteList(@RequestParam("type") Integer type) {
        return siteMapper.selectSite(type);
    }


    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response,@RequestParam("id")int id) throws UnsupportedEncodingException {
        String filename= newsService.selectFilaName(id);
        String filePath = "D:/upload" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
