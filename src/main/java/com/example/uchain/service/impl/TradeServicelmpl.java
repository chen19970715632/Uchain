package com.example.uchain.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Trade;
import com.example.uchain.mapper.TradeMapper;
import com.example.uchain.service.TradeService;
import com.example.uchain.utils.WeBASEUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TradeServicelmpl implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Autowired
    WeBASEUtils weBASEUtils;

    //    合约部署者的地址
    private static final String OWNER_ADDRESS = "0xca0df984b31e1f14270400c9fd91a036911ac1a5";

    //@Transactional(rollbackFor =Exception.class)出现所有异常都将事务回滚  spring事务管理
    //分页查询 未购买
    @Override
    public PageBean page(
            Integer Page,
            Integer pageSize,
            String ownerName,
            String workName,
            Integer CRId,
            String workType,
            String authorization,
            String blockAddress,
            Integer code) {

        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Trade> tradeList = tradeMapper.findAll(ownerName,workName,CRId,workType,authorization,blockAddress,code);

        // 获取分页信息
        Page<Trade> p = (Page<Trade>)  tradeList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

    //分页查询 已收藏
    @Override
    public PageBean page1(
            Integer Page,
            Integer pageSize,
            String ownerName,
            String workName,
            Integer CRId,
            String workType,
            String authorization,
            String blockAddress,
            Integer code) {

        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Trade> tradeList = tradeMapper.findAll2(ownerName,workName,CRId,workType,authorization,blockAddress,code);

        // 获取分页信息
        Page<Trade> p = (Page<Trade>)  tradeList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

    //分页查询 已收藏 未购买
    @Override
    public PageBean page2(
            Integer Page,
            Integer pageSize,
            String ownerName,
            String workName,
            Integer CRId,
            String workType,
            String authorization,
            String blockAddress,
            Integer code,
            Integer uid) {

        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Trade> tradeList = tradeMapper.findAll3(ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);

        // 获取分页信息
        Page<Trade> p = (Page<Trade>)  tradeList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

    //分页查询 已收藏 已购买
    @Override
    public PageBean page3(
            Integer Page,
            Integer pageSize,
            String ownerName,
            String workName,
            Integer CRId,
            String workType,
            String authorization,
            String blockAddress,
            Integer code,
            Integer uid) {

        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Trade> tradeList = tradeMapper.findAll4(ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);

        // 获取分页信息
        Page<Trade> p = (Page<Trade>)  tradeList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

    //分页查询  已购买
    @Override
    public PageBean page4(
            Integer Page,
            Integer pageSize,
            String ownerName,
            String workName,
            Integer CRId,
            String workType,
            String authorization,
            String blockAddress,
            Integer code,
            Integer uid) {

        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Trade> tradeList = tradeMapper.findAll5(ownerName,workName,CRId,workType,authorization,blockAddress,code,uid);

        // 获取分页信息
        Page<Trade> p = (Page<Trade>)  tradeList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }


    //添加
    @Override
    public void AddTrade(Trade trade) {
        tradeMapper.AddTrade(trade);
    }

    //删除
    @Override
    public void deleteTradeById(List<Integer> CRIds) {
        tradeMapper.deleteTradeById(CRIds);
    }

    //修改
    @Override
    public void updateById(Trade trade) {
        tradeMapper.updateById(trade);
    }

    //修改购买状态
    @Override
    public void updateById1(Trade trade) {
        trade.setTreadTime(LocalDateTime.now());
        tradeMapper.updateById1(trade);
    }

    //修改收藏状态
    @Override
    public Result updateById2(Trade trade) {
        tradeMapper.updateById2(trade);
        return Result.success(tradeMapper.findAll1(trade.getCRId())); // 将修改后的记录作为返回值返回
    }
    //修改展示状态
    @Override
    public Result updateById3(Trade trade) {
        tradeMapper.updateById3(trade);
        return Result.success(tradeMapper.findAll1(trade.getCRId())); // 将修改后的记录作为返回值返回
    }

    @Override
    public List<Trade> findAllPeople() {
        return tradeMapper.findAllPeople();
    }

    @Override
    public  List<Trade> tradeFindByUid(Integer uid) {
       return tradeMapper.tradeFindByUid(uid);
    }

    //根据id查找数据
    @Override
    public List<Trade> findAll1(Integer CRId) {
        return  tradeMapper.findAll1(CRId);
    }

    //交易信息上链
    @Override
    public Result AddChain1(Trade trade) {

        if (trade.getCRId() == null ||
                StrUtil.isEmpty(trade.getWorkName()) ||
                StrUtil.isEmpty(trade.getWorkType())  ||
                StrUtil.isEmpty(trade.getBlockAddress()) ||
                StrUtil.isEmpty(trade.getAuthorization())||
                trade.getPrice() == null
        ) {
            return Result.error(String.valueOf(Result.PARAM_EMPTY));
        } else {
            System.out.println(trade);
        }

        List<Serializable> funcParam = new ArrayList<>();

        funcParam.add(trade.getCRId());
        funcParam.add(trade.getWorkName());
        funcParam.add(trade.getWorkType());
        funcParam.add(trade.getBlockAddress());
        funcParam.add(trade.getAuthorization());
        funcParam.add(trade.getPrice());

        System.out.println(funcParam);

        String funcName="addTrade";
        String _result = weBASEUtils.funcPost2(OWNER_ADDRESS,funcName,funcParam);
        JSONObject _resultJson = JSONUtil.parseObj(_result);
        if (!_resultJson.containsKey("statusOK") || !_resultJson.getBool("statusOK")){
            return Result.error(String.valueOf(Result.CONTRACT_ERROR));
        }else{
            // 创建一个 Map 对象，将数据放入其中
            Map<String, Object> data = new HashMap<>();

            String transactionHash = _resultJson.getStr("transactionHash");
            String transactionIndex = _resultJson.getStr("transactionIndex");
            String blockNumber = _resultJson.getStr("blockNumber");
            String blockHash = _resultJson.getStr("blockHash");
            String from = _resultJson.getStr("from");
            String to = _resultJson.getStr("to");
            String message = _resultJson.getStr("message");
            String statusOK = _resultJson.getStr("statusOK");

            data.put("transactionHash", transactionHash);
            data.put("transactionIndex", transactionIndex);
            data.put("blockNumber", blockNumber);
            data.put("blockHash", blockHash);
            data.put("from", from);
            data.put("to", to);
            data.put("message", message);
            data.put("statusOK", statusOK);
                    
            // 将 Map 对象转换为 JSON 字符串
            String jsonData = JSONUtil.toJsonStr(data);

            // 将 JSON 字符串放入一个对象中并返回给前端
            Map<String, Object> result = new HashMap<>();
            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", jsonData);

            return Result.success(result);
        }
    }
    }
