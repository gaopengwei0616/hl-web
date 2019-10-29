package com.yida.service.impl;

import com.yida.entity.Ysqgk;
import com.yida.entity.Ysqgk_gm;
import com.yida.mapper.YsqgkMapper;
import com.yida.service.YsqgkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YsqgkServiceImpl implements YsqgkService {
    @Autowired
    private YsqgkMapper ysqgkMapper;

    @Override
    public List<Ysqgk> selectAllYsqgk() {
        return ysqgkMapper.selectAllYsqgk();
    }

    @Override
    public List<Ysqgk_gm> selectAllYsqgk_gm() {
        return ysqgkMapper.selectAllYsqgk_gm();
    }

    @Override
    public int updateStatus(int id) {
        return ysqgkMapper.updateStatus(id);
    }

    @Override
    public int refuseStatus(int id) {
        return ysqgkMapper.refuseStatus(id);
    }

    @Override
    public int updateGmStatus(int id) {
        return ysqgkMapper.updateGmStatus(id);
    }

    @Override
    public int refuseGmStatus(int id) {
        return ysqgkMapper.refuseGmStatus(id);
    }
}
