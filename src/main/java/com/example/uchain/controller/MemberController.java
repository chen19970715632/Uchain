package com.example.uchain.controller;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Member;
import com.example.uchain.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j//日志用的注解
public class MemberController {
    @Autowired
    private MemberService memberService;


    @GetMapping("/members")
    public Result page(@RequestParam(defaultValue = "1") Integer Page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String userName , Short sex
                       ){

        log.info("分页查询 参数:{},{},{},{}",Page,pageSize,userName,sex);
        PageBean pageBean=memberService.page(Page,pageSize,userName,sex);
        return Result.success(pageBean);
    }

    @PostMapping("/members")
    public Result AddMem(@RequestBody Member member){

        log.info("新增用户(注册添加): {}",member);
        memberService.AddMem(member);
        return Result.success();
    }

    @DeleteMapping("members/{ids}")
    public Result deleteMemById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除用户信息: {}",ids);
        memberService.deleteMemById(ids);
        return Result.success();
    }


    @PutMapping( "/recharge")
    public Result updateById(@RequestBody Member member){
        log.info("修改用户信息: {}", member);
        memberService.updateById(member);
        return Result.success( memberService.findAll1(member.getId()));
    }

    @GetMapping("/members1")
    public Result findAll1(@RequestParam("id") Integer id) {
        log.info("根据id查看会员信息");
        List<Member> memberList = memberService.findAll1(id);
        return Result.success(memberList);

    }

}
