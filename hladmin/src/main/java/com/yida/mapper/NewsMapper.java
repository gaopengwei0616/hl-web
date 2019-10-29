package com.yida.mapper;

import com.yida.entity.News;
import com.yida.entity.News1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    /*
    显示新闻
     */
    List<News> newsList(@Param("catid") int catid);

    News1 newsList1(@Param("id") int id);

    News xxgl(@Param("id") int id);

    News findNewsById(@Param("newsId") Integer newsId);

    void updateNewsById(News news);

    void insertNews(@Param("news") News news);

    int updateYwbj(@Param("id") int id, @Param("title") String title, @Param("keywords") String keywords);

    int updateYwbj1(@Param("id") int id, @Param("content") String content, @Param("copyfrom") String copyfrom);

    int updatexxgl(@Param("id") int id, @Param("title") String title, @Param("thumb") String thumb, @Param("description") String description, @Param("updatetime") String updatetime);

    void deleteNewsById(@Param("id") Integer id);

    News checkNewsByTitle(@Param("title") String title);

}
