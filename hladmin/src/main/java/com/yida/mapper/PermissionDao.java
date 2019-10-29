package com.yida.mapper;

import com.yida.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YD on 2019/7/25.
 */
@Repository
public interface PermissionDao {

    List<Permission> findAll();
    List<Permission> findByAdminUserId(int userId);

}
