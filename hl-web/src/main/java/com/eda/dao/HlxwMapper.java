/**2019年6月20日
 * 86176
 */
package com.eda.dao;

import com.eda.pojo.Hlxw;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 86176
 *
 */
@Repository
public interface HlxwMapper {
	
	/*
	 * 根据catid,id获取首页头部新闻的详细内容
	 */
	Hlxw hlxwList(@Param("id") Integer id);

	Hlxw hlxw(@Param("id") int id);

	Hlxw dzdt(@Param("id") int id, @Param("tableName") String tableName, @Param("tableName_data") String tableName_data);
}
