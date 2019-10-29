package com.yida.service;

import com.yida.entity.InternetSurvey;
import com.yida.entity.Survey;

import java.util.List;

public interface ComplaintBoxService {
    //网上调查
    List<InternetSurvey> selectInternetSurvey();

    List<Survey> selectSurveyByid(Integer parentId);

    List<Survey> selectSurveyByparentid(Integer parentId);

    List<Survey> selectSurveyList();

    int  deleteSurveybyid(Integer id);

    int deleteInternet_SurveyByid(Integer id);

    int insertInternetSurvey(InternetSurvey InternetSurvey);

    int insertSurvey(Survey Survey);
}
