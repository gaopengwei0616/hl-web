package com.yida.service.impl;

import com.github.pagehelper.PageInfo;
import com.yida.dao.CategoryDao;
import com.yida.dao.NewsDao;
import com.yida.dao.NewsDataDao;
import com.yida.entity.*;
import com.yida.mapper.InternetSurveyMapper;
import com.yida.mapper.RoleDaoMapper;
import com.yida.service.ComplaintBoxService;
import com.yida.service.LanmuguanliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/10.
 */
@Service
public class ComplaintBoxServiceImpl implements ComplaintBoxService {

    @Autowired
    InternetSurveyMapper internetSurvey;

    @Override
    public List<InternetSurvey> selectInternetSurvey() {
        return internetSurvey.selectInternetSurvey();
    }

    @Override
    public List<Survey> selectSurveyByid(Integer parentId) {
        return internetSurvey.selectSurveyByid(parentId);
    }

    @Override
    public List<Survey> selectSurveyByparentid(Integer parentId) {
        return internetSurvey.selectSurveyByparentid(parentId);
    }

    @Override
    public List<Survey> selectSurveyList() {
        return internetSurvey.selectSurveyList();
    }

    @Override
    public int deleteSurveybyid(Integer id) {
        return internetSurvey.deleteSurveybyid(id);
    }

    @Override
    public int deleteInternet_SurveyByid(Integer id) {
        return internetSurvey.deleteInternet_SurveyByid(id);
    }

    @Override
    public int insertInternetSurvey(InternetSurvey InternetSurvey) {
        return internetSurvey.insertInternetSurvey(InternetSurvey);
    }

    @Override
    public int insertSurvey(Survey Survey) {
        return internetSurvey.insertSurvey(Survey);
    }
}
