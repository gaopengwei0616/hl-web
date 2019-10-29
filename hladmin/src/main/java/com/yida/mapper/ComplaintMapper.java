package com.yida.mapper;

import com.yida.entity.Complaint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintMapper {
    public List<Complaint> selectComplaint();

    Integer deleteComplaintById(@Param("id") Integer id);

    List<Complaint> selectOpinionList();

    Integer deleteOpinionById(@Param("id") Integer id);

    Integer updateOpinionById(@Param("id") Integer id);
}
