package com.yida.mapper;

import com.yida.entity.Category;
import com.yida.entity.Site;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 栏目mapper
 * @author yeke
 */
@Repository
public interface CategoryMapper {

    List<Category> categoryLists(@Param("siteid")Integer siteid);

    List<Category> categoryListByModule(@Param("module")String module);

    Category findCategoryById(@Param("catid") Integer catid);

    List<Category> CategorysByParentId(@Param("parentid")Integer parent);

    Integer insertSelective(Category category);

    Integer updateByPrimaryKeySelective (Category category);
}
