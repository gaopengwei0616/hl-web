package com.yida.mapper;

import com.yida.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    List<Admin> adminList();

    Admin findAdminById(@Param("userId") Integer userId);

    Integer deleteAdminById(@Param("userId") Integer userId);

    Integer insertAdmin(Admin admin);

    Integer updateAdmin(Admin admin);

    Admin searchAdminByUsername(@Param("username")String username);

    Admin findAdminByName(@Param("username")String username);
}
