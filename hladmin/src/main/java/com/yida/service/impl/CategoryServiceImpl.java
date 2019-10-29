package com.yida.service.impl;

import com.yida.dao.SiteDao;
import com.yida.entity.Category;
import com.yida.entity.Site;
import com.yida.mapper.CategoryMapper;
import com.yida.mapper.SiteMapper;
import com.yida.service.CategoryService;
import com.yida.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rishun on 2019/7/23.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<com.yida.entity.Category> CategorysByParentId(Integer parentid) {
        return categoryMapper.CategorysByParentId(parentid);
    }

    @Override
    public int insertSelectiveCategory(com.yida.entity.Category category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int updateByPrimaryKeySelective(com.yida.entity.Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public List<Category> getCateList(Integer siteid) {
        return categoryMapper.categoryLists(siteid);
    }

    @Override
    public Integer deleteCategory(Integer catid) {
        Category categoryById = categoryMapper.findCategoryById(catid);
        categoryById.setStatus(0);
        return categoryMapper.updateByPrimaryKeySelective(categoryById);
    }

    @Override
    public Category getCategoryById(Integer catid) {
        return categoryMapper.findCategoryById(catid);
    }


}
