package com.eda.dao;

import com.eda.pojo.Pic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicsMapper {
	
	List<Pic> selectPics(@Param("catId") Integer catId, @Param("siteId") Integer siteId);
	List<Pic> selectPicsByCat_Code(@Param("cat_code") String cat_code, @Param("siteId") Integer siteId);
	List<Pic> selectPicsLimit(@Param("catId") Integer catId, @Param("siteId") Integer siteId, @Param("limitCount") Integer limitCount);
}
