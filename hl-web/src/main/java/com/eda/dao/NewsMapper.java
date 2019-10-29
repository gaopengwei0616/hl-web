package com.eda.dao;

import com.eda.pojo.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
	// String baseElements=" id,catid,title,status,createtime createTime,updatetime
	// updateTime ";
	// @Select("select "+baseElements+" from v9_news where catid =#{catid}")
	List<News> selectNews(@Param("catId") Integer catId, @Param("siteId") Integer siteId);
	List<News> selectNewsByCatCode(@Param("cat_code") String cat_code, @Param("siteId") Integer siteId);
	List<News> selectNewsByCatCode2(@Param("cat_code") String cat_code, @Param("siteId") Integer siteId,@Param("limitCount")Integer limitCount);
	List<News> selecthuilaiBycatId(@Param("catid") Integer catId);

	List<News> selectNewsLimit(@Param("catId") Integer catId, @Param("siteId") Integer siteId,
                               @Param("limitCount") Integer limitCount);

	News getNewsById(@Param("newsid") Integer newsid);

	/*
	古柏希 公开专栏（五公开，提案）
	 */
	List<News> selectNewsByparentid(@Param("catid")Integer catid);

	List<News> selectNewsBycatid(@Param("catid")Integer catid);

	List<News> selectByCatids(List list);

	List<News> selectByCatid(@Param("catid")Integer catid);
	/**
	 * 文件搜索
	 * @param title
	 * @return
	 */
	List<News> searchNew(@Param("title")String title);

	List<News> selectNewsBycatid2(@Param("parentid")Integer catid);

	List<News> selectZtzlAndLimit(@Param("catid")Integer catid);

}
