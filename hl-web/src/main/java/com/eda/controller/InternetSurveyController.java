package com.eda.controller;

import com.eda.pojo.InternetSurvey;
import com.eda.pojo.News;
import com.eda.pojo.Survey;
import com.eda.service.NewsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class InternetSurveyController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/internet_survey")
    public ModelAndView internet_survey(@RequestParam("siteid") Integer siteid) {
        List<InternetSurvey> InternetSurvey = newsService.selectInternetSurvey();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/internet_survey/wsdc");
        modelAndView.addObject("InternetSurvey", InternetSurvey);
        modelAndView.addObject("siteid", siteid);
        return modelAndView;
    }

    @GetMapping("/survey")
    public ModelAndView survey(@RequestParam("parentId") Integer parentId, @RequestParam("siteid") Integer siteid) {
        List<Survey> InternetSurvey = newsService.selectSurveyByid(parentId);
        List<Survey> survey = newsService.selectSurveyByparentid(parentId);

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);

        String time=InternetSurvey.get(0).getInternetSurvey().getEnd_time();

        //比当前日期小返回-1 	相等返回 0  比当前日期大 返回1
        int a=timeCompare(time,dateString);



        int sun = 0;
        for (int i = 0; i < survey.size(); i++) {
            sun += survey.get(i).getTicket();
        }
        ModelAndView modelAndView = new ModelAndView();
        String title = InternetSurvey.get(0).getInternetSurvey().getTitle();
        String End_time = InternetSurvey.get(0).getInternetSurvey().getEnd_time();
        int Id = InternetSurvey.get(0).getInternetSurvey().getId();
        modelAndView.setViewName("/internet_survey/showtitle");
        modelAndView.addObject("siteid", siteid);
        modelAndView.addObject("survey", survey);
        modelAndView.addObject("title", title);
        modelAndView.addObject("id", Id);
        modelAndView.addObject("a", a);
        modelAndView.addObject("sun", sun);
        modelAndView.addObject("End_time", End_time);
        return modelAndView;
    }
    public static int timeCompare(String t1,String t2){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1= Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        try {
            c1.setTime(formatter.parse(t1));
            c2.setTime(formatter.parse(t2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result=c1.compareTo(c2);
        return result;
    }

    @GetMapping("/surveyjdt")
    public ModelAndView surveyjdt(@RequestParam("parentId") Integer parentId, @RequestParam("siteid") Integer siteid) {
        List<Survey> InternetSurvey = newsService.selectSurveyByid(parentId);
        List<Survey> survey = newsService.selectSurveyByparentid(parentId);
        int sun = 0;
        for (int i = 0; i < survey.size(); i++) {
            sun += survey.get(i).getTicket();
        }
        for (Survey s1 : survey) {
            double sun2 = sun;
            double k = s1.getTicket();
            double l = k / sun2;
//            System.out.print(l);
            double ps=0;
            if(sun2!=0) {
                ps = divide(k, sun2, 2) * 100;
            }
            String ps1= String.valueOf(ps);
            String bai;
            bai= ps1.substring(0,2);
            if(survey.size()==1){
                bai="100";
            }
            String ps2 = bai + "%";
            System.out.print(ps2);
            s1.setPercentage(ps2);
        }
        ModelAndView modelAndView = new ModelAndView();
        String title = InternetSurvey.get(0).getInternetSurvey().getTitle();
        String End_time = InternetSurvey.get(0).getInternetSurvey().getEnd_time();
        modelAndView.setViewName("/internet_survey/showtitlejdt");
        modelAndView.addObject("siteid", siteid);
        modelAndView.addObject("survey", survey);
        modelAndView.addObject("title", title);
        modelAndView.addObject("sun", sun); //总票数
        modelAndView.addObject("End_time", End_time);
        return modelAndView;
    }

    /**
     *
     * @param a
     * @param b
     * @param scale 截取后n为
     * @return
     */
    public static double divide(double a, double b, int scale) {
        BigDecimal bd1 = new BigDecimal(Double.toString(a));
        BigDecimal bd2 = new BigDecimal(Double.toString(b));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @PostMapping("/toupiao")
    @ResponseBody
    public int toupiao(@RequestParam(value = "ticketid") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Survey survey=newsService.selectSurveyByids(id);
        int piao=survey.getTicket()+1;
        int msg= newsService.updateSurveyByid(id,piao);
        return msg;
    }
}
