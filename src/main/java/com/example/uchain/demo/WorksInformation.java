package com.example.uchain.demo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorksInformation {
    private Integer wid;//作品编号
    private  String worksName;//作品名称
    private  String worksProperty;//作品创作性质 0 1 2
    private LocalDateTime createTime;//创作/制作完成时间
    private String introduce;//内容简介
    private String createAddress;//创作完成地点
    private String publishState;//发表状态0 未完成 1 已完成
    private LocalDateTime firstpublishTime;//首次发布时间
    private String publishAddress;//发表地点

}
