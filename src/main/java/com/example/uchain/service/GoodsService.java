package com.example.uchain.service;

import com.example.uchain.demo.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAll();

    void AddGood(Goods goods);

    void deleteGoodById(List<Integer> ids);

    void updateById(Goods goods);
}
