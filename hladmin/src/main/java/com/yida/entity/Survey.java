package com.yida.entity;

import lombok.Data;

@Data
public class Survey {
    private  Integer Id;
    private int ticket;
    private String content;
    private int parent_id;
    private  InternetSurvey  internetSurvey;
    private String percentage;
}
