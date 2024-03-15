package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Works;
import com.example.uchain.service.WorksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class WorksController {

    @Autowired
    private WorksService worksService;


    @GetMapping("/works")
    public Result findAll() {
        log.info("查看所有作品信息");
        List<Works> worksList = worksService.findAll();
        return Result.success(worksList);
    }

    @PostMapping("/works")
    public Result AddWork(@RequestBody Works works){

        log.info("新增作品信息: {}",works);
        worksService.AddWork(works);
        return Result.success();
    }

    @DeleteMapping("works/{ids}")
    public Result deleteWorkById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除作品信息: {}",ids);
        worksService.deleteWorkById(ids);
        return Result.success();
    }

    @PutMapping( "/works")
    public Result updateById(@RequestBody Works works){
        log.info("修改作品信息: {}", works);
        worksService.updateById(works);
        return Result.success();
    }
}
