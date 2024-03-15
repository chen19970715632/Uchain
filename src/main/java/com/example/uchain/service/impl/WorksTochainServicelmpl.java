package com.example.uchain.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.WorksInformation;
import com.example.uchain.service.WorksTochainService;
import com.example.uchain.utils.WeBASEUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorksTochainServicelmpl implements WorksTochainService {

    @Autowired
    WeBASEUtils weBASEUtils;

    //    合约部署者的地址
    private static final String OWNER_ADDRESS = "0x8dc117b87c0bf3cfb6a520f77a5273e8c2566654";


    //信息上链
    @Override
    public Result AddChain(WorksInformation worksInformation) {

        if (worksInformation.getWid() == null ||
                StrUtil.isEmpty(worksInformation.getWorksName()) ||
                StrUtil.isEmpty(worksInformation.getWorksProperty())  ||
                StrUtil.isEmpty(worksInformation.getIntroduce()) ||
                StrUtil.isEmpty(worksInformation.getCreateAddress()) ||
                StrUtil.isEmpty(worksInformation.getPublishAddress())
        ) {
            return Result.error(String.valueOf(Result.PARAM_EMPTY));
        } else {
            System.out.println(worksInformation);
        }

        List<Serializable> funcParam = new ArrayList<>();

        funcParam.add(worksInformation.getWid());
        funcParam.add(worksInformation.getWorksName());
        funcParam.add(worksInformation.getWorksProperty());
        funcParam.add(worksInformation.getIntroduce());
        funcParam.add(worksInformation.getCreateAddress());
        funcParam.add(worksInformation.getPublishAddress());


        System.out.println(funcParam);

        String funcName="addWork";
        String _result = weBASEUtils.funcPost(OWNER_ADDRESS,funcName,funcParam);
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
