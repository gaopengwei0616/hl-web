package com.yida.service;

import com.yida.entity.Category;
import com.yida.entity.Site;

import java.util.List;

/**
 * Created by rishun on 2019/7/23.
 */
public interface CategoryService {

    List<Category> CategorysByParentId(Integer parentid);

    int insertSelectiveCategory(Category category);

    int  updateByPrimaryKeySelective (Category category);

    List<Category> getCateList(Integer siteid);

    Integer deleteCategory(Integer catid);

    Category getCategoryById(Integer catid);
}
