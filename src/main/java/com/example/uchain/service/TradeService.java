package com.example.uchain.service;

import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Trade;

import java.util.List;

public interface TradeService {

    PageBean page(Integer Page,
                  Integer pageSize,
                  String ownerName,
                  String workName,
                  Integer CRId,
                  String workType,
                  String authorization,
                  String blockAddress,
                  Integer code);

    void AddTrade(Trade trade);

    void deleteTradeById(List<Integer> CRIds);

    void updateById(Trade trade);

    void updateById1(Trade trade);

    Result updateById2(Trade trade);

    List<Trade> findAll1(Integer CRId);

    Result AddChain1(Trade trade);

    PageBean page1(Integer Page,
                  Integer pageSize,
                  String ownerName,
                  String workName,
                  Integer CRId,
                  String workType,
                  String authorization,
                  String blockAddress,
                  Integer code);

    PageBean page2(Integer Page,
                   Integer pageSize,
                   String ownerName,
                   String workName,
                   Integer CRId,
                   String workType,
                   String authorization,
                   String blockAddress,
                   Integer code,
                   Integer uid);

    PageBean page3(Integer Page,
                   Integer pageSize,
                   String ownerName,
                   String workName,
                   Integer CRId,
                   String workType,
                   String authorization,
                   String blockAddress,
                   Integer code,
                   Integer uid);

    PageBean page4(Integer Page,
                   Integer pageSize,
                   String ownerName,
                   String workName,
                   Integer CRId,
                   String workType,
                   String authorization,
                   String blockAddress,
                   Integer code,
                   Integer uid);

    Result updateById3(Trade trade);

    List<Trade> findAllPeople();

    List<Trade> tradeFindByUid(Integer uid);
}
