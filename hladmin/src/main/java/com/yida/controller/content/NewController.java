package com.yida.controller.content;

import com.yida.entity.News;
import com.yida.entity.News1;
import com.yida.mapper.NewsMapper;
import com.yida.service.LanmuguanliService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class NewController {

    @Autowired
    private LanmuguanliService lanmuguanliService;
    @Resource
    NewsMapper newsMapper;

    @RequestMapping(value = "yuanwen")
    public ModelAndView yuanwen(Model model,
                                @RequestParam("id") int id) {

        News1 yw = newsMapper.newsList1(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/ueditor/ywbj");
        model.addAttribute("yw", yw);
        return modelAndView;

    }

    @RequestMapping(value = "/pw/ywbj", method = RequestMethod.POST)
    @ResponseBody
    public int ywbj(@RequestParam("id") int id
            , @RequestParam("title") String title
            , @RequestParam("keywords") String keywords
            , @RequestParam(value = "content", required = false) Object content
            , @RequestParam("copyfrom") String copyfrom) {

        int result = newsMapper.updateYwbj(id, title, keywords);
        int result2 = newsMapper.updateYwbj1(id, content.toString(), copyfrom);
        return result + result2;
    }

    @RequestMapping("/pw/oneData")
    public ModelAndView xxgl(Model model, @RequestParam("id") int id) {
        News xx = newsMapper.xxgl(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/ueditor/xxgl");
        model.addAttribute("xx", xx);
        return modelAndView;
    }

    //修改信息
    @RequestMapping("/xgxx")
    @ResponseBody
    public int xxgl(@RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("thumb") String thumb,
                    @RequestParam("description") String description, @RequestParam("updatetime") String updatetime) {
        int result = newsMapper.updatexxgl(id, title, thumb, description, updatetime);
        return result;
    }

    @RequestMapping("/ueditor/add_accessory")
    public String file(){
        return "/ueditor/add_accessory";
    }

    @RequestMapping("upload_accessory")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam("id")int id){
        if(file.isEmpty()){
            return "文件或文件大小不能为空";
        }
        String fileName = file.getOriginalFilename();
        String size =  file.getSize() +"B";

        lanmuguanliService.addAccessory(fileName,size,id);

        String path = "D:/upload" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "上传失败";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
