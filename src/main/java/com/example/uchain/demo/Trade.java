package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private String ownerName;// 版权所有者姓名
    private String ownerContact;// 版权所有者联系方式
    private String workName;// 作品名称
    private String workType;// 作品类型
    private String tradingTime;// 挂牌时长
    private String blockAddress; // 区块地址
    private String certificateFile;// 版权证明材料
    private Integer CRId;// 版权编号
    private String authorization;// 版权授权方式
    private Integer price;// 交易价格
    private String PurchaseState; //购买状态 0为false 1为true
    private String FavoritesState;//收藏状态 0为false 1为true
    private LocalDateTime treadTime;//交易时间
    private String isExpand;//是否展示详细信息
    private Integer uid;//购买者id

}
