package com.example.uchain.controller;

import cn.hutool.json.JSONObject;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.WorksInformation;
import com.example.uchain.service.WorksInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@Slf4j//日志用的注解
public class WorksInformationController {

    @Autowired
    private WorksInformationService worksInformationService;

    @GetMapping("/information")
    public Result findAll() {
        log.info("查看所有作品信息");
        List<WorksInformation> worksInformationList = worksInformationService.findAll();
        return Result.success(worksInformationList);
    }

    @PostMapping("/information")
    public Result AddInformation(@RequestBody JSONObject param){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        WorksInformation w = new WorksInformation();
        w.setWid((Integer) param.get("wid"));
        w.setCreateAddress((String) param.get("createAddress"));
        w.setIntroduce((String) param.get("introduce"));
        w.setWorksName((String)param.get("worksName"));
        w.setWorksProperty((String) param.get("worksProperty"));
        w.setPublishAddress((String) param.get("publishAddress"));
        w.setCreateTime(LocalDateTime.parse((String)param.get("createTime"), formatter) );
        w.setPublishState((String) param.get("publishState"));
        w.setFirstpublishTime(LocalDateTime.parse((String)param.get("firstpublishTime"), formatter) );
        log.info("新增作品信息: {}",w);
        worksInformationService.AddInformation(w);
        return Result.success();
    }

    @GetMapping("/information1")
    public Result page(@RequestParam(defaultValue = "1") Integer Page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String worksName,
                       String worksProperty ,
                       String publishAddress,
                       String publishState,
                       String createAddress,
                       Integer wid,
                       Integer code){

        log.info("分页查询 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,worksName,worksProperty,publishAddress,publishState,createAddress,wid,code);
        PageBean pageBean=worksInformationService.page(Page,pageSize,worksName,worksProperty,publishAddress,publishState,createAddress,wid,code);
        return Result.success(pageBean);
    }

    @DeleteMapping ("information/{wids}")
    public Result deleteInformationById(@PathVariable("wids") List<Integer> wids){
        log.info("根据id批量删除作品信息: {}",wids);
        worksInformationService.deleteInformationById(wids);
        return Result.success();
    }

    @PutMapping( "/information")
    public Result updateById(@RequestBody WorksInformation worksInformation){
        log.info("修改作品信息: {}", worksInformation);
        worksInformationService.updateById(worksInformation);
        return Result.success();
    }



}
