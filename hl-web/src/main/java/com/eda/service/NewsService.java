package com.eda.service;

import com.eda.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService {
	/**
	 * 根据catid和区域获取对应的新闻
	 * 
	 * @param catId
	 * @param siteId
	 * @return
	 */

	List<News> selectNewsBycatId(Integer catId, Integer siteId);
	List<News> selectNewsByCatCode(String cat_code, Integer siteId);
	List<News> selectNewsByCatCode2(String cat_code, Integer siteId,Integer limitCount);
	List<News> selectNewsBycatId2(Integer catId, Integer siteId, Integer limitCount);

	/**
	 * 根据type获取站点类别
	 * 
	 * @param type
	 * @return
	 */
	List<Site> selectSiteList(Integer type);

	/**
	 * 根据catid获取图片
	 * 
	 * @param catId
	 * @return
	 */
	List<Pic> selectPics(Integer catId, Integer siteId);
	List<Pic> selectPics(String cat_code, Integer siteId);
	List<Pic> selectPics(Integer catId, Integer siteId, Integer limitCount);
	/**
	 * 根据catid获取走进惠来新闻
	 * 
	 * @param catId
	 * @return
	 */
	List<News> selectNewList(Integer catId);

	Hlxw hlxwList( Integer Id);
	/*
	 * 通过区域id获取当前区域下所有的categoryid
	 */
	Category selectCategoryId(int siteId,  String catname);

	/*
	 * 通过页面的父级模块ID查询出其子模块信息
	 */
	List<Category> selectByParentId( int siteId);

	News getNewsById(Integer newsid);

	Site findSiteById(Integer siteid);

	/*
	古柏希 公开专栏（五公开，提案）
	 */
	List<News> selectNewsByparentid(Integer catid);

	List<News> selectNewsBycatid(Integer catid);
	/**
	 * 文件搜索
	 * @param title
	 * @return
	 */
	List<News> searchNew(String title);
	
	//意见箱
	
	List<Complaint> selectyijian(); 
	
	 Complaint selecttoushu(String identity_card,String name); 
	
	 int insertcomplaint(Complaint complaint);
	 
	 List<News> selectTitleByCid(Integer catid);

	 //网上调查
	 List<InternetSurvey> selectInternetSurvey();

	List<Survey> selectSurveyByid(Integer parentId);

	List<Survey> selectSurveyByparentid(Integer parentId);

	List<News> selectNewsBycatid2(Integer catid);

	int updateSurveyByid(int ticketid,int ticket);

	Survey selectSurveyByids(int id);

	//g
	List<News> selectByCatids(List list);

	List<News> selectByCatid(@Param("catid")Integer catid);

	List<News> selectZtzlAndLimit(@Param("catid")Integer catid);

	String selectFilaName(@Param("id")int id);


}
