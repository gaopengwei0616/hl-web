package com.yida.controller.content;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yida.entity.*;
import com.yida.service.*;
import com.yida.utiles.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeke on 2019/7/8.
 * 管理内容Controller
 */
@Controller
public class LanmuguanliController {

    @Autowired
    private LanmuguanliService lanmuguanliService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private AdministerService administerService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private YsqgkService ysqgkService;


    //管理内容页面跳转
    @RequestMapping("/showLists")
    public ModelAndView lanmuguanli(Authentication authentication,
                                    @RequestParam(defaultValue = "-1",name = "siteid")Integer siteid,
                                    @RequestParam(defaultValue = "0", name = "catid") Integer catid,
                                    @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
                                    @RequestParam(defaultValue = "0", name = "pageNum", required = false) Integer pageNum) {
        Integer siteByRoleId = lanmuguanliService.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        PageHelper.startPage(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = lanmuguanliService.showLanmuguanliMessage(catid);
        PageInfo<News> newsList = (PageInfo<News>) map.get("newsList");
        modelAndView.addObject("page", newsList);
        modelAndView.addObject("pageList", newsList.getList());
        modelAndView.setViewName("/Content/lanmuguanli");
        modelAndView.addObject("value", 1);
        modelAndView.addObject("catid", catid);
        if(siteid!=-1){
            modelAndView.addObject("siteid",siteid);
        }else{
            modelAndView.addObject("siteid",siteByRoleId);
        }
        return modelAndView;
    }

    //跳转数据内容添加修改页面
    @GetMapping("/add_edit_newsData")
    public ModelAndView editNewsData(@RequestParam(name = "news_id",required = false) Integer id,
                                     @RequestParam(name = "catid") Integer catid,
                                     @RequestParam(name = "type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<>();
        if(type.equals("edit")){
            map = lanmuguanliService.editContentSearch(id, catid);
            modelAndView.addObject("newsData", map.get("newsData"));
            modelAndView.addObject("news", map.get("news"));
        }
        if(type.equals("add")){
            map = lanmuguanliService.addContentSearch(catid);
            modelAndView.addObject("catid", catid);
        }
        modelAndView.setViewName("/ueditor/add_edit_newsData");
        modelAndView.addObject("category", map.get("category"));
        modelAndView.addObject("type", type);
        return modelAndView;
    }


    //修改数据
    @PostMapping("/edit_news_data")
    public ModelAndView editNewsData(@RequestParam(name = "newsid") Integer newsid,
                                @RequestParam(name = "newsDataId") Integer newsDataId,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "content") String content,
                                @RequestParam(name = "keywords")String keywords,
                                @RequestParam(name = "updatetime")String updatetime,//修改时间,
                                @RequestParam(name = "url")String url,
                                @RequestParam(name = "status")Integer status,
                                @RequestParam(name = "description")String description
    ) {
        lanmuguanliService.updateNewsAndNewsData(newsid,newsDataId, title, content,keywords,url,status,description,updatetime);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/showLists");
        return modelAndView;
    }
    //添加数据
    @PostMapping("/add_news_data")
    public ModelAndView addNewsData(@RequestParam(name = "catid") Integer catid,
                                    @RequestParam(name = "title",required = false) String title,
                                    @RequestParam(name = "content",defaultValue = "",required = false) String content,
                                    @RequestParam(name = "source", required = false) String source,
                                    @RequestParam(name = "description", required = false) String description,
                                    @RequestParam(name = "typeid", required = false) Integer typeid,
                                    @RequestParam(name = "keywords",defaultValue = "",required=false)String keywords,//关键字
                                    @RequestParam(name = "inputtime",required = false)String inputtime,//添加时间
                                    @RequestParam(name = "status",required = false)Integer status,//状态
                                    @RequestParam(name = "fileName") MultipartFile file

    ) {
        // 要上传的目标文件存放路径
        String localPath = "D:\\huilaiadmin\\image";
        // 上传成功或者失败的提示
        String msg = "";
        String thumb="";
         System.out.println(file.getResource().getFilename());
        if(file.getResource().getFilename()!=""&&!file.getResource().getFilename().equals("")) {
        	thumb= FileNameUtils.getFileName(file.getOriginalFilename()); 
        	if (upload(file, localPath, thumb)) {
                // 上传成功，给出页面提示
                msg = "上传成功！";
            } else {
                msg = "上传失败！";
            }
        }
            
        
        lanmuguanliService.insertNewsAndNewsData(catid, title, source, description, typeid, content,keywords,inputtime,status,thumb);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", msg);
        String aa= "D:\\huilaiadmin\\image\\"+file.getOriginalFilename();
        modelAndView.addObject("filename",aa);
        modelAndView.setViewName("redirect:/showLists");
        return modelAndView;
    }

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String name){

        // 生成新的文件名
        String realPath = path + "/" +name ;

        //使用原文件名
//        String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
    //删除数据
    @GetMapping("/del_news_data")
    @ResponseBody
    public Integer delNewsData(@RequestParam("id") Integer id){
        return lanmuguanliService.deleteNewsAndNewsData(id);
    }


    //获取导航栏数据内容列表
    @GetMapping("/catParentDirList")
    @ResponseBody
    public List<Category> catParentDirList(@RequestParam(name = "siteid",defaultValue = "1")Integer siteid) {
        Map<String, Object> map = lanmuguanliService.catParentDirList(siteid);
        List<Category> categories = (List<Category>)map.get("categories");
        return categories;
    }

    //检查标题是否重复
    @GetMapping("/checkNewsTitle")
    @ResponseBody
    public Integer checkNewsTitle(@RequestParam(name = "title") String title,
                                 @RequestParam(name = "type")String type,
                                 @RequestParam(name = "newsId",required = false)Integer newsId){
        if(title.equals("")){
            return 0;
        }
        return lanmuguanliService.checkNewsTitle(title,type,newsId);
    }

    //显示站点
    @PostMapping("/showSites")
    @ResponseBody
    public List<Site> showSites(Authentication authentication){

     /*   System.out.println("roleid:"+administerService.findAdminByName(authentication.getName()).getRoleid());
        System.out.println(lanmuguanliService.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid()));
*/

        Integer siteByRoleId = lanmuguanliService.getSiteByRoleId(administerService.findAdminByName(authentication.getName()).getRoleid());
        if(siteByRoleId!=1){
            List<Site> list = new ArrayList<>();
            list.add(siteService.SiteBysiteId(siteByRoleId));
            return list;
        }
        List<Site> sites=new ArrayList<>();
        List<Site> site0=siteService.SiteBysiteType(0);
        List<Site> site2=siteService.SiteBysiteType(2);
        List<Site> site1=siteService.SiteBysiteType(1);
        for (int i = 0; i <site0.size() ; i++) {
            sites.add(site0.get(i));
        }
        for (int i = 0; i <site2.size() ; i++) {
            sites.add(site2.get(i));
        }
        for (int i = 0; i <site1.size() ; i++) {
            sites.add(site1.get(i));
        }
        return sites;
    }

    //跳转到管理栏目页面
    @RequestMapping("/siteSelect")
    public String siteSelect(){
        return "/Content/ManageProgram/siteSelect";
    }
    //跳转到投诉意见栏目页面
    @RequestMapping("/complaintList")
    public String complaintList(){
        return "/Content/ManageProgram/complaintList";
    }
    //显示投诉
    @PostMapping("/showComplaint")
    @ResponseBody
    public List<Complaint> showComplaints(){
        List<Complaint> complaintList = siteService.GetComplaintsList();
        return complaintList;
    }
    //删除投诉
    @RequestMapping("/deleteComplaint")
    @ResponseBody
    public Integer deleteComplaint(@RequestParam("id")Integer id){
        return siteService.deleteComplaintById(id);
    }
    //跳转到意见栏目页面
    @RequestMapping("/opinionList")
    public String opinionList(){
        return "/Content/ManageProgram/opinionList";
    }
    //显示意见
    @PostMapping("/showOpinion")
    @ResponseBody
    public List<Complaint> showOpinions(){
        List<Complaint> opinionsList = siteService.GetOpinionsList();
        return opinionsList;
    }
    //删除意见
    @RequestMapping("/deleteOpinion")
    @ResponseBody
    public Integer deleteOpinion(@RequestParam("id")Integer id){
        return siteService.deleteOpinionById(id);
    }


    //采纳意见
    @RequestMapping("/updateOpinion")
    @ResponseBody
    public Integer updateOpinion(@RequestParam("id")Integer id){
        return siteService.updateOpinionById(id);
    }

    //跳转到站点栏目页面
    @RequestMapping("/goManager")
    public ModelAndView goManager(@RequestParam("siteid")Integer siteid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Content/ManageProgram/goManager");
        modelAndView.addObject("siteid",siteid);
        return modelAndView;
    }

    //获取指定站点的栏目
    @PostMapping("/getCateList")
    @ResponseBody
    public List<Category> getCateList(@RequestParam("siteid")Integer siteid){
        return categoryService.getCateList(siteid);
    }


    @RequestMapping("/addEditCategory")
    public ModelAndView  addCatrgory(@RequestParam(required = false,name = "siteid")Integer siteid,
                                     @RequestParam(required = false,name = "catid")Integer catid,
                                     @RequestParam("type")String type){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Content/ManageProgram/add_edit_Catrgory");
        modelAndView.addObject("siteid",siteid);
        modelAndView.addObject("type",type);
        Site site = siteService.SiteBysiteId(siteid);
        modelAndView.addObject("site",site);
        if(type.equals("edit")){
            Category categoryById = categoryService.getCategoryById(catid);
            modelAndView.addObject("categoryById",categoryById);
        }
        return modelAndView;
    }

    @PostMapping("/addCategory")
    public ModelAndView addCategory(@RequestParam("siteid") Integer siteid,
                                    @RequestParam("catname")String catname,
                                    @RequestParam("catparid") Integer catparid,
                                    @RequestParam("cat_code")String cat_code,
                                    @RequestParam("description")String description,
                                    @RequestParam("ismenu")Integer ismenu){
        Category category = new Category();
        category.setParentid(catparid);
        category.setCat_code(cat_code);
        category.setDescription(description);
        category.setSiteid(siteid);
        category.setName(catname);
        category.setStatus(1);

        category.setImage(" ");
        category.setUrl("");
        category.setIsmenu(ismenu);
        categoryService.insertSelectiveCategory(category);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goManager?siteid="+siteid);
        return modelAndView;
    }

    @PostMapping("/editCategory")
    public ModelAndView editCategory(@RequestParam("siteid") Integer siteid,
                                     @RequestParam("catname")String catname,
                                     @RequestParam("catid") Integer catid,
                                     @RequestParam("catparid")Integer catparid,
                                     @RequestParam("cat_code")String cat_code,
                                     @RequestParam("description")String description){
        Category category = categoryService.getCategoryById(catid);
        category.setName(catname);
        category.setCat_code(cat_code);
        category.setDescription(description);
        if(catparid==null){
            category.setParentid(0);
        }else{
            category.setParentid(catparid);
        }
        categoryService.updateByPrimaryKeySelective(category);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goManager?siteid="+siteid);
        return modelAndView;
    }

    @GetMapping("/deleteCategory")
    @ResponseBody
    public Integer deleteCategory(@RequestParam("catid")Integer catid){
        return categoryService.deleteCategory(catid);
    }

    @RequestMapping("/ysqgk")
    public ModelAndView ysqgk(
                              @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
                              @RequestParam(defaultValue = "0", name = "pageNum", required = false) Integer pageNum) {
        List<Ysqgk> ysqgkList = ysqgkService.selectAllYsqgk();
        PageHelper.startPage(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Ysqgk> list = new PageInfo<Ysqgk>(ysqgkList);
        modelAndView.addObject("page", list);
        modelAndView.addObject("pageList", list.getList());
        modelAndView.setViewName("/ysqgk");
        return modelAndView;
    }
    @RequestMapping("/edit_ysqgk")
    @ResponseBody
    public Integer edit_ysqgk(int id){
       return ysqgkService.updateStatus(id);
    }

    @RequestMapping("/refuse_ysqgk")
    @ResponseBody
    public Integer refuse_ysqgk(int id){
        return ysqgkService.refuseStatus(id);
    }

    @RequestMapping("/ysqgk_gm")
    public ModelAndView ysqgk_gm(
            @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
            @RequestParam(defaultValue = "0", name = "pageNum", required = false) Integer pageNum) {
        List<Ysqgk_gm> ysqgk_gm = ysqgkService.selectAllYsqgk_gm();
        PageHelper.startPage(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Ysqgk_gm> list = new PageInfo<Ysqgk_gm>(ysqgk_gm);
        modelAndView.addObject("page", list);
        modelAndView.addObject("pageList", list.getList());
        modelAndView.setViewName("/ysqgk_gm");
        return modelAndView;
    }
    @RequestMapping("/edit_ysqgk_gm")
    @ResponseBody
    public Integer edit_ysqgk_gm(int id){
        return ysqgkService.updateGmStatus(id);
    }

    @RequestMapping("/refuse_ysqgk_gm")
    @ResponseBody
    public Integer refuse_ysqgk_gm(int id){
        return ysqgkService.refuseGmStatus(id);
    }

    @RequestMapping("/add_accessory")
    public ModelAndView add_accessory(int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("/ueditor/add_accessory");
        return modelAndView;
    }

}