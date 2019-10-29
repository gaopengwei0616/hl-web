package com.eda.dao;

import com.eda.pojo.Gongkai;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GongkaiMapper {
    List<Gongkai> selectByCatid(@Param("catid") Integer catid);

    List<Gongkai> selectZdlyByCatid(@Param("catid") Integer catid);

    List<Gongkai> selectZdlyByParentId(@Param("catid") Integer catid);
}
