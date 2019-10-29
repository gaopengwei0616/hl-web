package com.yida.entity;

import lombok.Data;

/**
 * 栏目entity
 * @author yeke
 */
@Data
public class Category {
    private Integer catid;
    private Integer siteid;
    private Integer parentid;
    private String name;
    private String image;
    private String description;
    private String url;
    private Integer ismenu;
    private Integer status;
    private String cat_code;
}
