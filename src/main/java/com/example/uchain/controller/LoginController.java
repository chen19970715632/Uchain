package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Member;
import com.example.uchain.service.MemberService;
import com.example.uchain.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j//日志用的注解
public class LoginController {

    @Autowired
    private MemberService memberService;


    @PostMapping("/login")
    public Result login(@RequestBody Member member){

        log.info("用户登录:{}",member);
        Member m =memberService.login(member);

        // 登录成功，生成令牌，下发令牌
        if (m != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", m.getId());
            claims.put("name", m.getUserName());

            // 生成JWT令牌
            String jwt = JwtUtils.generateJwt(claims);

            // 创建返回结果Map
            Map<String, Object> result = new HashMap<>();
            result.put("jwt", jwt);
            result.put("id", m.getId());

            return Result.success(result);
        }

        return Result.error("账号或密码错误");

    }



}
