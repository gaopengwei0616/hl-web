package com.eda.service.Impl;

import com.eda.dao.*;
import com.eda.pojo.*;
import com.eda.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private ComplaintMapper complaintMapper;
	
	@Autowired
	private SiteMapper siteMapper;
	
	@Autowired
	private PicsMapper picsMapper;

	@Autowired
	private HlxwMapper hlxwMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private InternetSurveyMapper internetSurveyMapper;
	@Autowired
	private AccessoryMapper accessoryMapper;

	@Override
	public List<News> selectNewsBycatId(Integer catId,Integer siteId) {
		return newsMapper.selectNews(catId,siteId);
	}

	@Override
	public List<News> selectNewsByCatCode(String cat_code, Integer siteId) {
		return newsMapper.selectNewsByCatCode(cat_code,siteId);
	}

	@Override
	public List<News> selectNewsByCatCode2(String cat_code, Integer siteId, Integer limitCount) {
		return newsMapper.selectNewsByCatCode2(cat_code,siteId,limitCount);
	}

	@Override
	public List<Site> selectSiteList(Integer type) {
		return siteMapper.selectSite(type);
	}

	@Override
	public List<Pic> selectPics(Integer catId, Integer siteId) {
		return picsMapper.selectPics(catId, siteId);
	}

	@Override
	public List<Pic> selectPics(String cat_code, Integer siteId) {
		return picsMapper.selectPicsByCat_Code(cat_code,siteId);
	}

	@Override
	public List<News> selectNewList(Integer catId) {
		return newsMapper.selecthuilaiBycatId(catId);
	}

	@Override
	public List<News> selectNewsBycatId2(Integer catId, Integer siteId, Integer limitCount) {
		return newsMapper.selectNewsLimit(catId, siteId, limitCount);
	}

	@Override
	public List<Pic> selectPics(Integer catId, Integer siteId, Integer limitCount) {
		return picsMapper.selectPicsLimit(catId, siteId, limitCount);
	}

	@Override
	public Hlxw hlxwList(Integer Id) {
		// TODO Auto-generated method stub
		return hlxwMapper.hlxwList(Id);
	}
	/* (non-Javadoc)
	 * @see com.huilai.service.NewsService#selectCategoryId(int, java.lang.String)
	 */
	@Override
	public Category selectCategoryId(int siteId,String catname) {
		// TODO Auto-generated method stub
		
		return categoryMapper.selectCategoryId(siteId,catname);
	}

	/* (non-Javadoc)
	 * @see com.huilai.service.NewsService#selectByParentId(int)
	 */
	@Override
	public List<Category> selectByParentId(int siteId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByParentId(siteId);
	}

	@Override
	public News getNewsById(Integer newsid) {
		return newsMapper.getNewsById(newsid);
	}

	@Override
	public Site findSiteById(Integer siteid) {
		return siteMapper.findSiteById(siteid);
	}

	@Override
	public List<News> selectNewsByparentid(Integer catid){
		return newsMapper.selectNewsByparentid(catid);
	}

	@Override
	public List<News> selectNewsBycatid(Integer catid){
		return newsMapper.selectNewsBycatid(catid);
	}

	@Override
	public List<News> searchNew(String title) {
		// TODO Auto-generated method stub
		return newsMapper.searchNew(title);
	}

	@Override
	public List<Complaint> selectyijian() {
		// TODO Auto-generated method stub
		return complaintMapper.selectyijian();
	}

	@Override
	public Complaint selecttoushu(String identity_card, String name) {
		// TODO Auto-generated method stub
		return complaintMapper.selecttoushu(identity_card, name);
	}

	@Override
	public int insertcomplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		return complaintMapper.insertcomplaint(complaint);
	}
	@Override
	public List<News> selectTitleByCid(Integer catid) {
		return newsMapper.selectNewsBycatid(catid);
	}

	@Override
	public List<InternetSurvey> selectInternetSurvey() {
		return internetSurveyMapper.selectInternetSurvey();
	}

	@Override
	public List<Survey> selectSurveyByid(Integer parentId) {
		return internetSurveyMapper.selectSurveyByid(parentId);
	}

	@Override
	public List<Survey> selectSurveyByparentid(Integer parentId) {
		return internetSurveyMapper.selectSurveyByparentid(parentId);
	}

	@Override
	public List<News> selectNewsBycatid2(Integer catid){
		return newsMapper.selectNewsBycatid2(catid);
	}


	@Override
	public List<News> selectByCatid(Integer catid){
		return newsMapper.selectByCatid(catid);
	}

	@Override
	public List<News> selectByCatids(List list){
		return newsMapper.selectByCatids(list);
	}

	@Override
	public List<News> selectZtzlAndLimit(Integer catid){
		return newsMapper.selectZtzlAndLimit(catid);
	}

	@Override
	public String selectFilaName(int id) {
		return accessoryMapper.selectFileName(id);
	}

	@Override
	public int updateSurveyByid(int ticketid, int ticket) {
		return internetSurveyMapper.updateSurveyByid(ticketid,ticket);
	}

	@Override
	public Survey selectSurveyByids(int id) {
		return internetSurveyMapper.selectSurveyByids(id);
	}


}
