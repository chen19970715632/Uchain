package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Works {
    private Integer Id;//作品编号
    private String name;//作品名
    private Integer archorId;//作者id
}
