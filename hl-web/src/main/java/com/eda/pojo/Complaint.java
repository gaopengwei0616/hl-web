package com.eda.pojo;

import lombok.Data;

@Data
public class Complaint {
private int id;  
private String name; //姓名
private String identity_card; //身份证号
private String unit;  //单位
private String address; //地址
private String postcode; //邮编
private String phone;     //电话
private String email;    //邮箱
private String title;  //标题
private String content; //内容
private String status;  //0代表意见1代表投诉
private String inputtime;  //创建时间
private String updatetime;  //更新时间
private String yjstatus;
}
