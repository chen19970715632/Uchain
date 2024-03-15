package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Visitor;
import com.example.uchain.service.VisitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class VisitorColler {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitor")
    public Result findAll() {
        log.info("查看游客信息");
        List<Visitor> visitorList = visitorService.findAll();
        return Result.success(visitorList);
    }

    @PostMapping("/visitor")
    public Result AddViS(@RequestBody Visitor visitor){

        log.info("新增游客: {}",visitor);
        visitorService.AddViS(visitor);
        return Result.success();
    }

    @DeleteMapping("visitor/{ids}")
    public Result deleteVisById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除游客: {}",ids);
        visitorService.deleteVisById(ids);
        return Result.success();
    }


}
