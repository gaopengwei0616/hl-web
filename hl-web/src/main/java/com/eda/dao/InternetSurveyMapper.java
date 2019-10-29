package com.eda.dao;

import com.eda.pojo.Gongkai;
import com.eda.pojo.InternetSurvey;
import com.eda.pojo.Survey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternetSurveyMapper {

    List<Survey> selectSurveyByid(@Param("parentid") int parentid);

    List<InternetSurvey> selectInternetSurvey();

    List<Survey> selectSurveyByparentid(@Param("parentid") int parentid);

    int updateSurveyByid(@Param("ticketid") int ticketid,@Param("ticket") int ticket );

    Survey selectSurveyByids(@Param("id") int id);

}
