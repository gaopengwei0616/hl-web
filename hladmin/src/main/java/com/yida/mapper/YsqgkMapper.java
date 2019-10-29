package com.yida.mapper;

import com.yida.entity.Ysqgk;
import com.yida.entity.Ysqgk_gm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YsqgkMapper {

    List<Ysqgk_gm> selectAllYsqgk_gm();

    List<Ysqgk> selectAllYsqgk();

    int updateStatus(int id);

    int refuseStatus(int id);

    int updateGmStatus(int id);

    int refuseGmStatus(int id);
}
