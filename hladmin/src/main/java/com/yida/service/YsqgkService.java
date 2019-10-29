package com.yida.service;

import com.yida.entity.Ysqgk;
import com.yida.entity.Ysqgk_gm;

import java.util.List;

public interface YsqgkService {
    List<Ysqgk> selectAllYsqgk();

    List<Ysqgk_gm> selectAllYsqgk_gm();

    int updateStatus(int id);

    int refuseStatus(int id);

    int updateGmStatus(int id);

    int refuseGmStatus(int id);
}
