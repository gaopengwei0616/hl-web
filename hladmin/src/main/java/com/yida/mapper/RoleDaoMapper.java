package com.yida.mapper;

import com.yida.entity.Site;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YD on 2019/8/6.
 */
@Repository
public interface RoleDaoMapper {

    Integer getSiteByRoleId(@Param("roleid") Integer roleid);
}
