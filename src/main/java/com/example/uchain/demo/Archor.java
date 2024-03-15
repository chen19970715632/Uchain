package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Archor {
    private String kind;//类别
    private String name;//著作权人
    private Integer idType;//证件号类型 0身份证 1港澳 2 ....
    private String idNumber;//证件号
    private LocalDateTime createTime;//证件起始时间
    private LocalDateTime endTime;//证件结束时间
    private LocalDateTime updateTime;//数据更新时间
    private Integer memberId;//成员id  --> 会员id
    private Integer ifLongterm;//是否长期有效 1 是 0不是
    private String address;//地址
}
