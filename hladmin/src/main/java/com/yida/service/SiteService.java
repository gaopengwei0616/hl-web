package com.yida.service;

import com.yida.entity.Complaint;
import com.yida.entity.Site;

import java.util.List;

/**
 * Created by rishun on 2019/7/10.
 */
public interface SiteService {
    /**
     * 获取区域数据列表
     *
     * @return
     */
    List<Site> GetSiteList();

    /***
     * 根据Siteid修改数据
     * @param site
     * @return
     */
    int updateBySite(Integer siteId, Site site);

    /***
     * 根据siteId修改状态 1:未删除，要显示,0:已删除未显示
     * @param siteId
     * @return
     */
    int updateBysiteId(Integer siteId, Integer status);

    /***
     * \ 根据siteid查询site信息
     * @param siteId
     * @return
     */
    Site SiteBysiteId(Integer siteId);


    /***
     *  选择性添加site
     * @param site
     * @return
     */
    int insertSelective(Site site);


    Integer insertSite(String name,String dirname,String domain,String siteTitle,String keywords,String description,String release_point,Integer siteType);
    Integer updateSite(Integer siteId,String name,String dirname,String domain,String siteTitle,String keywords,String description,String release_point,Integer siteType);

    List<Complaint> GetComplaintsList();


    Integer deleteComplaintById(Integer id);

    List<Complaint> GetOpinionsList();

    Integer deleteOpinionById(Integer id);

    Integer updateOpinionById(Integer id);

    List<Site> SiteBysiteType(int type);
}
