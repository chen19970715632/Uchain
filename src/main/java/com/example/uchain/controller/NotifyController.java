package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Notify;
import com.example.uchain.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    @GetMapping("/notify")
    public Result findAll() {
        log.info("查看信息");
        List<Notify> notifyList = notifyService.findAll();
        return Result.success(notifyList);
    }

    @PostMapping("/notify")
    public Result AddNOti(@RequestBody Notify notify){

        log.info("新增消息: {}",notify);
        notifyService.AddNOti(notify);
        return Result.success();
    }

    @DeleteMapping("notify/{ids}")
    public Result deleteNOtiById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除信息: {}",ids);
        notifyService.deleteNOtiById(ids);
        return Result.success();
    }


    @PutMapping( "/notify")
    public Result updateById(@RequestBody Notify notify){
        log.info("修改信息: {}", notify);
        notifyService.updateById(notify);
        return Result.success();
    }

}
