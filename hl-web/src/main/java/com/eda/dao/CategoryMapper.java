package com.eda.dao;

import com.eda.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
	
	/*
	 * 通过区域id获取当前区域下所有的categoryid
	 */
	Category selectCategoryId(@Param("siteId") int siteId);

	Category selectCategoryId(@Param("siteId") int siteId, @Param("catname") String catname);

	/*
	 * 通过页面的父级模块ID查询出其子模块信息
	 */
	List<Category> selectByParentId(@Param("parentid") Integer parentid);


	List<Category> selectCategoryByCode(@Param("cat_code") String catcode,@Param("siteid")Integer siteid);

	List<Category> selectAllByParentId99();
	
	List<Category> selectCategoryByXzzl(@Param("siteId") int siteId);
	
	Integer selectCategoryForId(@Param("siteId") int siteId);

	List<Category> selectZtzl(@Param("parentid") Integer parentid);

	List<Category> selectZtzl2(@Param("catid") Integer catid);

	int selectCatid(@Param("siteid") int siteid);
}
