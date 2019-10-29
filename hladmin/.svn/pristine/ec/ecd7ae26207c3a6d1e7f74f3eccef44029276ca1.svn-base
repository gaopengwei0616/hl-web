package com.yida.dao;

import com.yida.entity.NewsData;
import com.yida.mapper.NewsDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yeke on 2019/7/10.
 */
@Component
public class NewsDataDao {

    @Autowired
    private NewsDataMapper newsDataMapper;

    public int insertNewsData(Integer newsId,String content){
        NewsData newsData = new NewsData();
        newsData.setId(newsId);
        newsData.setContent(content);
        int count=newsDataMapper.insertNewsData(newsData);
        return count;
    }
    public void updateNewsDataById(Integer newsId,String content){
        newsDataMapper.updateNewsDataById(newsId,content);
    }

    public NewsData newsDatafindById(Integer id){
        return newsDataMapper.findNewsDataByNewsId(id);
    }
}
