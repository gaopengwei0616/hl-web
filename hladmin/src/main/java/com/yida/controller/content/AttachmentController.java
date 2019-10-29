package com.yida.controller.content;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yida.entity.Attachment;
import com.yida.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by rishun on 2019/7/4.
 * 附件管理
 */
@Controller
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    /* 附件数据列表数据 */
    @GetMapping("/Attachmentlist")
    @ResponseBody
    public ModelAndView fujianguanlie(@RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize, //页数量
                                      @RequestParam(defaultValue = "0", name = "pageNum", required = false) Integer pageNum      //当前页
    ) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum, pageSize);
        List<Attachment> attachments = attachmentService.seleAttachmentBypaging();
        PageInfo<Attachment> page = new PageInfo<Attachment>(attachments);
        modelAndView.setViewName("/Content/AttachmentManage");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageList", page.getList());
        modelAndView.addObject("value", 1);
        return modelAndView;
    }

    /* 删除附件 */
    @RequestMapping("/delectByid")
    @ResponseBody
    public Integer delectBy(@RequestParam("aid") int aid, Model model) {
        int status = 0; //状态0:已删除,1：数据显示
        int count = attachmentService.updateByaId(aid, status);//是否删除成功
        return count;
    }


}
