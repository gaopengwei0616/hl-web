package com.yida.controller.content;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yida.entity.InternetSurvey;
import com.yida.entity.Site;
import com.yida.entity.Survey;
import com.yida.service.ComplaintBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ComplaintBoxController {
    @Autowired
    private ComplaintBoxService complaintBoxService;

    /**
     *  返回投票页面
     * @return
     */
    @RequestMapping("/complaintBoxList")
    public String complaintBoxList(){
        return "/Content/ComplaintBox/complaintBoxList";
    }

    /**
     * 返回投票list数据
     * @return
     */
    @PostMapping("/ComplaintBoxList")
    @ResponseBody
    public List<Survey> getCateComplaintBoxList(){
       List<Survey> list= complaintBoxService.selectSurveyList();
        return list;
    }



    /**
     * 删除
     * @return
     */
    @PostMapping("/ComplaintBoxDelete")
    @ResponseBody
    public int ComplaintBoxDelete(@RequestParam ("id")int id){
        int  a= complaintBoxService.deleteSurveybyid(id);
        int b=complaintBoxService.deleteInternet_SurveyByid(id);
        int count=0;
        if(a==b){
           count=1;
        }
        return count;
    }
    //跳转添加修改投票页面
    @RequestMapping("/addEditComplaintBox")
    public ModelAndView addEditComplaintBox(@RequestParam(name = "type")String type,
                                    @RequestParam(name = "siteId",required = false)Integer siteId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Content/ComplaintBox/add_edit_complaintBox");
        if(type.equals("edit")){
           /* Site site = siteService.SiteBysiteId(siteId);
            modelAndView.addObject("site",site);*/
        }
        modelAndView.addObject("type",type);
        return modelAndView;
    }
    @PostMapping("/addComplaintBox")
    @Transactional
    public ModelAndView addCategory(@RequestParam(name="tplx",required=false) String tplx,
                                    @RequestParam(name="title",required=false)String title,
                                    @RequestParam(name="begin_time",required=false) String begin_time,
                                        @RequestParam(name="end_time",required=false)String end_time,
                                    @RequestParam(name="description",required=false)String description
                                   ){
        try {
            int id=insertInternetSurvey(begin_time,end_time,title,description);
//            System.out.println("rows = " + count); // 添加操作返回记录数
//            System.out.println("id = " + internetsurvey.getId()); // 执行添加操作之后通过Java对象获取主键属性值
            Survey survey=new Survey();
            /**
             *  拆分以  ,  隔开的值
             */
            String str = tplx;
            String [] clzss = str.split(",");
            List<String> cls = new ArrayList<String>();
            for(int i=0;i<clzss.length;i++){
                cls.add( clzss[i]);
            }
            for (int i=0;i<cls.size();i++){
                survey.setContent(cls.get(i));
                survey.setParent_id(id);
                survey.setTicket(0);
                complaintBoxService.insertSurvey(survey);
            }

        }catch (Exception e){

        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/complaintBoxList");
        return modelAndView;
    }

    /**
     *  
     * @param begin_time
     * @param end_time
     * @param title
     * @param description
     * @return
     */
    private int insertInternetSurvey(String begin_time, String end_time, String title, String description) {
        InternetSurvey internetsurvey=new InternetSurvey();
        internetsurvey.setBegin_time(begin_time);
        internetsurvey.setEnd_time(end_time);
        internetsurvey.setTitle(title);
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        internetsurvey.setCreate_time(sdf.format(new Date()));
        internetsurvey.setDescription(description);
        int count=0;
        count= complaintBoxService.insertInternetSurvey(internetsurvey);
        return  internetsurvey.getId();
    }
}
