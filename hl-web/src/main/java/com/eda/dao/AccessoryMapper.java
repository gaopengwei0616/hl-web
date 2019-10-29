package com.eda.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AccessoryMapper {

	String selectFileName(@Param("id")int id);

}
