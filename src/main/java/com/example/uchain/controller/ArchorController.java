package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Archor;
import com.example.uchain.service.ArchorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class ArchorController {

    @Autowired
    private ArchorService archorService;

    @GetMapping("/archor")
    public Result findAll() {
        log.info("查看所有著作人信息");
        List<Archor> goodsList = archorService.findAll();
        return Result.success(goodsList);
    }

    @PostMapping("/archor")
    public Result AddArchor(@RequestBody Archor archor){

        log.info("新增著作人信息: {}",archor);
        archorService.AddArchor(archor);
        return Result.success();
    }

    @DeleteMapping("archor/{memberIds}")
    public Result deleteArchorById(@PathVariable("memberIds") List<Integer> memberIds){
        log.info("根据id批量删除著作人信息: {}",memberIds);
        archorService.deleteArchorById(memberIds);
        return Result.success();
    }

    @PutMapping( "/archor")
    public Result updateById(@RequestBody Archor archor){
        log.info("修改著作人信息: {}", archor);
        archorService.updateById(archor);
        return Result.success();
    }


}
