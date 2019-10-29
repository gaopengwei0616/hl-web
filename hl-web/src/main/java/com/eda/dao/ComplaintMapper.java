package com.eda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eda.pojo.Complaint;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintMapper {
	
	public List<Complaint> selectyijian(); 
	
	public Complaint selecttoushu(@Param("identity_card")String identity_card,@Param("name")String name); 
	
	public int insertcomplaint(Complaint complaint);

}
