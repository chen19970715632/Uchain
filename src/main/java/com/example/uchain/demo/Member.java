package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String userName;//会员名字
    private Integer Id;//会员id
    private Integer sign;//标识符 1 会员 2 管理员
    private Integer age; //年龄
    private short sex;//性别
    private String phoneNumber; //手机号
    private String password;//密码
    private String email;//邮箱
    private String qq;//QQ
    private String wx;//微信
    private String balance;//余额
    private String blockAddress;//区块地址

}
