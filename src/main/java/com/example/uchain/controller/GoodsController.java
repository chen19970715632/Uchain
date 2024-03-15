package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.demo.Goods;
import com.example.uchain.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public Result findAll() {
        log.info("查看所有商品信息");
        List<Goods> goodsList = goodsService.findAll();
        return Result.success(goodsList);
    }

    @PostMapping("/goods")
    public Result AddGood(@RequestBody Goods goods){

        log.info("新增商品信息: {}",goods);
        goodsService.AddGood(goods);
        return Result.success();
    }

    @DeleteMapping("goods/{ids}")
    public Result deleteGoodById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除商品信息: {}",ids);
        goodsService.deleteGoodById(ids);
        return Result.success();
    }

    @PutMapping( "/goods")
    public Result updateById(@RequestBody Goods goods){
        log.info("修改会员信息: {}", goods);
        goodsService.updateById(goods);
        return Result.success();
    }

}
