package com.yida.mapper;

import com.yida.entity.NewsData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeke
 */
@Repository
public interface NewsDataMapper {

    List<NewsData> findNewsDataList();

    NewsData findNewsDataByNewsId(@Param("id") Integer newsId);

    Integer updateNewsDataById(@Param("id") Integer id, @Param("content") String content);

    int insertNewsData(@Param("news_data") NewsData newsData);
}
