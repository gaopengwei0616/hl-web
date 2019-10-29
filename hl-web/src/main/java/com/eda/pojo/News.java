package com.eda.pojo;

import lombok.Data;

@Data
public class News {
	private Integer id;
	private Integer catid;    // 类型id
	private String title;     // 标题
	private Integer status;   // 状态
	private String source;			//来源
	private String createTime; // 创建时间
	private String updateTime; // 修改时间
	private String thumb;
	private Category category; 

	
}
