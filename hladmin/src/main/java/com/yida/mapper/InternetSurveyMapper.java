package com.yida.mapper;

import com.yida.entity.InternetSurvey;
import com.yida.entity.Survey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternetSurveyMapper {

    List<Survey> selectSurveyByid(@Param("parentid") int parentid);

    List<InternetSurvey> selectInternetSurvey();

    List<Survey> selectSurveyByparentid(@Param("parentid") int parentid);

    List<Survey>   selectSurveyList();

    int   deleteSurveybyid(@Param("id") int id);

    int  deleteInternet_SurveyByid(@Param("id") int id);

    int  insertInternetSurvey(InternetSurvey InternetSurvey);

    int  insertSurvey (@Param("Survey")Survey Survey);

}
