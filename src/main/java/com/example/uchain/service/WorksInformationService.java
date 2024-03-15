package com.example.uchain.service;

import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Trade;
import com.example.uchain.demo.WorksInformation;

import java.util.List;

public interface WorksInformationService {

    List<WorksInformation> findAll();

    void AddInformation(WorksInformation worksInformation);

    void deleteInformationById(List<Integer> wids);

    void updateById(WorksInformation worksInformation);

    PageBean page(Integer Page, Integer pageSize,
                  String worksName,
                  String worksProperty,
                  String publishAddress,
                  String publishState,
                  String createAddress,
                  Integer wid,
                  Integer code);
}
