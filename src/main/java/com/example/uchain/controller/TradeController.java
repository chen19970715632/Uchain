package com.example.uchain.controller;

import cn.hutool.json.JSONObject;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Trade;
import com.example.uchain.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("/queryTrading")
    public Result page(@RequestParam(defaultValue = "1") Integer Page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String ownerName,
                       String workName ,
                       Integer CRId,
                       String workType,
                       String authorization,
                       String blockAddress,
                       Integer code){

        log.info("分页查询挂牌版权信息 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code);
        PageBean pageBean=tradeService.page(Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code);
        System.out.println(pageBean);
        return Result.success(pageBean);
    }

    @GetMapping("/queryTrading1")
    public Result page1(@RequestParam(defaultValue = "1") Integer Page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String ownerName,
                       String workName ,
                       Integer CRId,
                       String workType,
                       String authorization,
                       String blockAddress,
                       Integer code){

        log.info("分页查询挂牌版权信息 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code);
        PageBean pageBean=tradeService.page1(Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code);
        return Result.success(pageBean);
    }
    @GetMapping("/queryTrading2")
    public Result page2(@RequestParam(defaultValue = "1") Integer Page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String ownerName,
                        String workName ,
                        Integer CRId,
                        String workType,
                        String authorization,
                        String blockAddress,
                        Integer code,
                        Integer uid){

        log.info("分页查询挂牌版权信息 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);
        PageBean pageBean=tradeService.page2(Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);
        return Result.success(pageBean);
    }
    @GetMapping("/queryTrading3")
    public Result page3(@RequestParam(defaultValue = "1") Integer Page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String ownerName,
                        String workName ,
                        Integer CRId,
                        String workType,
                        String authorization,
                        String blockAddress,
                        Integer code,
                        Integer uid){

        log.info("分页查询挂牌版权信息 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);
        PageBean pageBean=tradeService.page3(Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);
        return Result.success(pageBean);
    }

    @GetMapping("/queryTrading4")
    public Result page4(@RequestParam(defaultValue = "1") Integer Page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String ownerName,
                        String workName ,
                        Integer CRId,
                        String workType,
                        String authorization,
                        String blockAddress,
                        Integer code,
                        Integer uid){

        log.info("分页查询挂牌版权信息 参数:{},{},{},{},{},{},{},{},{}",Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,uid);
        PageBean pageBean=tradeService.page4(Page,pageSize,ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);
        return Result.success(pageBean);
    }

    @PostMapping("/trade")
    public Result AddTrade(@RequestBody Trade trade){

        log.info("新增购买版权信息: {}",trade);
        tradeService.AddTrade(trade);
        return Result.success();
    }

    @DeleteMapping("trade/{CRIds}")
    public Result deleteTradeById(@PathVariable("CRIds") List<Integer> CRIds){
        log.info("根据id批量删除挂牌版权信息: {}",CRIds);
        tradeService.deleteTradeById(CRIds);
        return Result.success();
    }


    @GetMapping("tradeFindByUid")
    public Result tradeFindByUid(Integer uid){
        log.info("根据id查询该条交易信息: {}",uid);
        tradeService.tradeFindByUid(uid);
        return Result.success();
    }

    @PutMapping( "/trade")
    public Result updateById(@RequestBody Trade trade){
        log.info("修改挂牌版权信息: {}", trade);
        tradeService.updateById(trade);
        return Result.success();
    }
    @PutMapping( "/trade1")
    public Result updateById1(@RequestBody Trade trade){
        log.info("修改购买状态信息: {}", trade);
        tradeService.updateById1(trade);
        return Result.success();
    }
    @PutMapping( "/trade2")
    public Result updateById2(@RequestBody Trade trade){
        log.info("修改收藏状态信息: {}", trade);
        tradeService.updateById2(trade);
        return Result.success(tradeService.findAll1(trade.getCRId()));
    }

    @PutMapping( "/trade3")
    public Result updateById3(@RequestBody Trade trade){
        log.info("修改展示状态信息: {}", trade);
        tradeService.updateById3(trade);
        return Result.success(tradeService.findAll1(trade.getCRId()));
    }
    @GetMapping("/trade11")
    public Result findAllPeople() {
        log.info("查看热门权益人信息");
        List<Trade> treadList = tradeService.findAllPeople();
        return Result.success(treadList);
    }
    //交易信息上链 ——> 交易凭证
    @PostMapping("/addChain1")
    public Result AddChain1(@RequestBody JSONObject param){
        Trade t = new Trade();
        t.setCRId((Integer) param.get("CRId"));
        t.setWorkName((String) param.get("workName"));
        t.setWorkType((String) param.get("workType"));
        t.setBlockAddress((String)param.get("blockAddress"));
        t.setAuthorization((String) param.get("authorization"));
        t.setPrice((Integer) param.get("price"));
        log.info("交易信息上链: {}",t);
        return tradeService.AddChain1(t);
    }

}
