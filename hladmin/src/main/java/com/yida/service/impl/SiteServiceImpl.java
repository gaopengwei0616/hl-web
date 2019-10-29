package com.yida.service.impl;

import com.yida.dao.SiteDao;
import com.yida.entity.Complaint;
import com.yida.entity.Site;
import com.yida.entity.SysRole;
import com.yida.mapper.ComplaintMapper;
import com.yida.mapper.RoleMapper;
import com.yida.mapper.SiteMapper;
import com.yida.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rishun on 2019/7/10.
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteMapper siteMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SiteDao siteDao;
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public List<Site> GetSiteList() {
        return siteMapper.GetSiteList();
    }

    @Override
    public int updateBySite(Integer siteId,Site site) {
        return siteMapper.updateBySite(site);
    }

    @Override
    public int updateBysiteId(Integer siteId,Integer status) {
        return siteMapper.updateBysiteId(siteId,status);
    }

    @Override
    public Site SiteBysiteId(Integer siteId) {
        return siteMapper.SiteBysiteId(siteId);
    }

    @Override
    public int insertSelective(Site site) {
        return siteMapper.insertSelective(site);
    }

    @Override
    public Integer insertSite(String name, String dirname, String domain, String siteTitle, String keywords, String description, String release_point,Integer siteType) {
        SysRole role = new SysRole();
        role.setName("ROLE_USER");
        role.setDescription(name);
        role.setRolename("管理员:"+name);
        roleMapper.insertRole(role);
        return siteDao.insertSite(name,dirname,domain,siteTitle,keywords,description,release_point,siteType);
    }

    @Override
    public Integer updateSite(Integer siteId, String name, String dirname, String domain, String siteTitle, String keywords, String description, String release_point, Integer siteType) {
        return siteDao.updateSite(siteId,name,dirname,domain,siteTitle,keywords,description,release_point,siteType);
    }
    @Override
    public List<Complaint> GetComplaintsList(){
        return complaintMapper.selectComplaint();
    }
    @Override
    public Integer deleteComplaintById(Integer id){
        return complaintMapper.deleteComplaintById(id);
    }
    @Override
    public List<Complaint> GetOpinionsList(){
        return complaintMapper.selectOpinionList();
    }
    @Override
    public Integer deleteOpinionById(Integer id){
        return complaintMapper.deleteOpinionById(id);
    }
    @Override
    public Integer updateOpinionById(Integer id){
        return complaintMapper.updateOpinionById(id);
    }

    @Override
    public List<Site> SiteBysiteType(int type) {
        return siteMapper.SiteBysiteType(type);
    }
}
