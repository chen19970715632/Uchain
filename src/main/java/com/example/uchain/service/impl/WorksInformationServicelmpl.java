package com.example.uchain.service.impl;

import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.WorksInformation;
import com.example.uchain.mapper.WorksInformationMapper;
import com.example.uchain.service.WorksInformationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Service
public class WorksInformationServicelmpl implements WorksInformationService {
    @Autowired
    private WorksInformationMapper worksInformationMapper;


    //查询
    @Override
    public List<WorksInformation> findAll() {
        return worksInformationMapper.findAll();
    }

    //添加
    @Override
    public void AddInformation(WorksInformation worksInformation) {
        worksInformation.setFirstpublishTime(LocalDateTime.now());
        worksInformationMapper.AddInformation(worksInformation);

    }

    //删除
    @Override
    public void deleteInformationById(List<Integer> wids) {
        worksInformationMapper.deleteInformationById(wids);
    }

    //修改
    @Override
    public void updateById(WorksInformation worksInformation) {
        worksInformationMapper.updateById(worksInformation);
    }

    @Override
    public PageBean page(Integer Page, Integer pageSize, String worksName,
                         String worksProperty,
                         String publishAddress,
                         String publishState,
                         String createAddress,
                         Integer wid,
                         Integer code) {
        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<WorksInformation> worksInformationList = worksInformationMapper.findAll1(worksName, worksProperty, publishAddress, publishState, createAddress, wid, code);

        // 获取分页信息
        Page<WorksInformation> p = (Page<WorksInformation>) worksInformationList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

}
