package com.yida.mapper;

import com.yida.entity.CateLocation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YD on 2019/8/19.
 */
@Repository
public interface CateLocationMapper {
    List<CateLocation> cateLocationList();
}
