package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWorks {

    private String worksType;//作品类型
    private String worksFile;//作品附加文件
    private Integer workId;//作品编号
}
