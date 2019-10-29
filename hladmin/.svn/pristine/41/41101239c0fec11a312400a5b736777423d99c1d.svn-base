package com.yida.controller.content;

import com.yida.dao.CategoryDao;
import com.yida.entity.Category;
import com.yida.mapper.RoleDaoMapper;
import com.yida.service.AdministerService;
import com.yida.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rishun on 2019/7/18.
 * 管理栏目
 */
@Controller
public class ManagerProgramController {
    @Autowired
    private AdministerService administerService;
    @Autowired
    private RoleDaoMapper roleDaoMapper;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryService categoryService;

    //跳转栏目管理
    @RequestMapping("/ManagerProgramList")
    public ModelAndView guanlilangmu1(Authentication authentication,
                                      @RequestParam(defaultValue = "-1",name = "siteid")Integer siteid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Content/ManageProgram");
        Integer siteByRoleId = roleDaoMapper.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        if(siteid==-1){
            modelAndView.addObject("siteid",siteByRoleId);
        }else{
            modelAndView.addObject("siteid",siteid);
        }
        return modelAndView;
    }

    //ajax返回form表单数据
    @PostMapping("/ManagerProgramajax")
    @ResponseBody
    public Map<String, Object> guanlilangmu(Authentication authentication,@RequestParam(name = "siteid") Integer siteid) {
        List<Category> categorys = categoryDao.categoryLists(siteid);
        int count=categorys.size();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("categorys",categorys);
        modelMap.put("count",count);
        return modelMap;
    }


    //添加或者删除返回到html
    /*@RequestMapping("/addEditCategory")
    public ModelAndView addEditCategory(@RequestParam(name = "type",required=false)String type,
                                        @RequestParam(name="parentid",required=false)Integer parentid,
                                        @RequestParam(name="catId",required=false)Integer catId){
        ModelAndView modelAndView = new ModelAndView();
        if(type.equals("add")){
          List<Category> categorylist= categoryService.CategorysByParentId(parentid);
            modelAndView.addObject("categorylist",categorylist);
            modelAndView.setViewName("/Content/ManageProgram/add_edit_Program");
        }
        if(type.equals("edit")){
            Category editcategory=categoryDao.getCategoryById(catId);
            modelAndView.addObject("category",editcategory);
            List<Category> categorylist= categoryService.CategorysByParentId(parentid);
            modelAndView.addObject("categorylist",categorylist);
           modelAndView.setViewName("/Content/ManageProgram/add_edit_Program");
        }
        modelAndView.addObject("type",type);
        return modelAndView;
    }*/

    //添加栏目
    @PostMapping("/insertCategory")
    public ModelAndView insertCategory(@RequestParam("catname")String catname,
                                   @RequestParam("catdir")String catdir,
                                   @RequestParam("parentid")int parentid,
                                   @RequestParam("image")String image,
                                   @RequestParam("description")String description,
                                   @RequestParam("cat_code")String cat_code){
        Category category=new Category();
        category.setSiteid(1);
        category.setParentid(parentid);
        category.setName(catname);
        category.setImage(image);
        category.setDescription(description);
        category.setStatus(1);
        category.setUrl("");
        category.setIsmenu(0);
        category.setStatus(1);
        category.setCat_code(cat_code);
          int count  =categoryService.insertSelectiveCategory(category);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ManagerProgramList");
        return modelAndView;
    }

    //修改栏目
    @PostMapping("/EditCategory")
    public ModelAndView update(@RequestParam("catname")String catname,
                                   @RequestParam("catdir")String catdir,
                                   @RequestParam("parentid")int parentid,
                                   @RequestParam("image")String image,
                                   @RequestParam("description")String description,
                               @RequestParam("catid")int catid,
                               @RequestParam("cat_code")String cat_code){
        Category category=new Category();
        category.setParentid(parentid);
        category.setName(catname);
        category.setImage(image);
        category.setCatid(catid);
        category.setDescription(description);
        category.setCat_code(cat_code);

        int count  =categoryService.updateByPrimaryKeySelective(category);
        System.out.print(count);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ManagerProgramList");
        return modelAndView;
    }

    //删除栏目
    @GetMapping("/deleCategory")
    public ModelAndView delecategory(@RequestParam("catid")int catid){
        Category category=new Category();
        category.setCatid(catid);
        category.setStatus(0);
        int count  =categoryService.updateByPrimaryKeySelective(category);
        System.out.print(count);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ManagerProgramList");
        return modelAndView;
    }

    //文件上传
    @PostMapping("/upload") // 等价于 @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uplaod(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) {//1. 接受上传的文件  @RequestParam("file") MultipartFile file
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            m.addAttribute("fileName", fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "news_data";
    }
}
