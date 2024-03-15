package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer price; //商品价格
    private Integer worksId; //作品编号
    private String name;//商品名字
    private Integer Id;//商品id
    private Integer blockNumber;//区块号
}
