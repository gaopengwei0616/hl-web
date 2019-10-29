package com.eda.dao;

import com.eda.pojo.Site;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteMapper {

	List<Site> selectSite(@Param("type") Integer type);

	Site findSiteById(@Param("siteid")Integer siteid);
}
