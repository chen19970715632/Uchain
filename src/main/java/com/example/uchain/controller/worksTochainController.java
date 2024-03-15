package com.example.uchain.controller;

import cn.hutool.json.JSONObject;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.WorksInformation;
import com.example.uchain.service.WorksTochainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j//日志用的注解
public class worksTochainController {

    @Autowired
    private WorksTochainService worksTochainService;

    //信息上链
    @PostMapping("/addChain")
    public Result AddChain(@RequestBody JSONObject param){

        WorksInformation w = new WorksInformation();
        w.setWid((Integer) param.get("wid"));
        w.setCreateAddress((String) param.get("createAddress"));
        w.setIntroduce((String) param.get("introduce"));
        w.setWorksName((String)param.get("worksName"));
        w.setWorksProperty((String) param.get("worksProperty"));
        w.setPublishAddress((String) param.get("publishAddress"));
        log.info("作品信息上链: {}",w);
        return worksTochainService.AddChain(w);
    }
}
