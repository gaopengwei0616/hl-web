package com.yida.controller.content;

import com.yida.entity.CateLocation;
import com.yida.mapper.CateLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YD on 2019/8/19.
 */
@Controller
public class CateLocationController {

    @Autowired
    private CateLocationMapper cateLocationMapper;

    @RequestMapping("/CateLocation")
    public String CateLocationList(){
        return "/Content/CateLocation";
    }

    @GetMapping("/CateLocationList")
    @ResponseBody
    public List<CateLocation> getCateLocationList(){
        return cateLocationMapper.cateLocationList();
    }
}
