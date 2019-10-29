package com.yida.entity;

import lombok.Data;

/**
 * Created by rishun on 2019/7/10.
 */
@Data
public class Site {
    private Integer siteid;
    private String name;
    private String keywords;
    private String description;
    private Integer type;
    private Integer status;
}