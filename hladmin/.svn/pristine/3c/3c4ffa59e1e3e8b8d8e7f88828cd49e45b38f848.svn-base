package com.yida.dao;

import com.yida.entity.Site;
import com.yida.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/7/19.
 */
@Component
public class SiteDao {

    @Autowired
    private SiteMapper siteMapper;

    public Integer insertSite(String name,String dirname,String domain,String siteTitle,String keywords,String description,String release_point,Integer siteType){
        Site site = new Site();
        site.setName(name);
        site.setKeywords(keywords);
        site.setDescription(description);
        site.setType(siteType);
        site.setStatus(1);
        return siteMapper.insertSelective(site);
    }

    public Integer updateSite(Integer siteId,String name,String dirname,String domain,String siteTitle,String keywords,String description,String release_point,Integer siteType){
        Site site = new Site();
        site.setSiteid(siteId);
        site.setName(name);
        site.setKeywords(keywords);
        site.setDescription(description);
        site.setType(siteType);
        return siteMapper.updateBySite(site);
    }
}
