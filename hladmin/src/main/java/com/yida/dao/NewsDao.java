package com.yida.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yida.entity.News;
import com.yida.mapper.NewsMapper;

/**
 * Created by yeke on 2019/7/10.
 */
@Component
public class NewsDao {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> newsList(int catid){
        return newsMapper.newsList(catid);
    }

    public News findNewsById(Integer newsId){
        return newsMapper.findNewsById(newsId);
    }

    public void updateNewsById(Integer newsid,String title,String keywords,String url,Integer status,String description,String updatetime){
        News news = new News();
        news.setId(newsid);
        news.setTitle(title);
        news.setKeywords(keywords);
        news.setUrl(url);
        news.setStatus(status);
        news.setDescription(description);
        news.setUpdatetime(updatetime);

        newsMapper.updateNewsById(news);
    }

    public Integer insertNews(Integer catid,String title,String source,String username,String description,String keywords,String inputtime,Integer status,String thumb){
        News news = new News();
        news.setCatid(catid);
        news.setTitle(title);
        news.setSource(source);
        news.setUsername(username);
        news.setDescription(description);
        news.setKeywords(keywords);
        news.setInputtime(inputtime);
        news.setStatus(status);
        news.setThumb(thumb);
        newsMapper.insertNews(news);
        return news.getId();
    }

    public void deleteNewsById(Integer id){
        newsMapper.deleteNewsById(id);
    }

    public News checkNewsByTitle(String title){
        return newsMapper.checkNewsByTitle(title);
    }

}
