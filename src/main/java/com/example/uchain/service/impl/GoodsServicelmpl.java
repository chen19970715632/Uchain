package com.example.uchain.service.impl;

import com.example.uchain.demo.Goods;
import com.example.uchain.mapper.GoodsMapper;
import com.example.uchain.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServicelmpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    //查询
    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }
    //添加
    @Override
    public void AddGood(Goods goods) {
        goodsMapper.AddGood(goods);
    }

    //删除
    @Override
    public void deleteGoodById(List<Integer> ids) {
        goodsMapper.deleteGoodById(ids);
    }

    //修改
    @Override
    public void updateById(Goods goods) {
        goodsMapper.updateById(goods);
    }
}
