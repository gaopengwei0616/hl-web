package com.yida.dao;

import com.yida.entity.Category;
import com.yida.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yeke on 2019/7/10.
 * category栏目Dao
 */
@Component
public class CategoryDao {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category getCategoryById(Integer id){
        return categoryMapper.findCategoryById(id);
    }

    public List<Category> categoryLists(Integer siteid) {
        return categoryMapper.categoryLists(siteid);
    }

    public List<Category> categoryListById(String module){
        return categoryMapper.categoryListByModule(module);
    }
}
