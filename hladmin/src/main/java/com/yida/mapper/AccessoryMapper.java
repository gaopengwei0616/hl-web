package com.yida.mapper;

import com.yida.entity.News;
import com.yida.entity.News1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessoryMapper {

    void addAccessory(@Param("fileName") String fileName,@Param("fileSize") String fileSize,@Param("id")int id);
}
