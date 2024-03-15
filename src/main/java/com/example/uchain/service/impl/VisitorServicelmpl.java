package com.example.uchain.service.impl;

import com.example.uchain.demo.Visitor;
import com.example.uchain.mapper.VisitorMapper;
import com.example.uchain.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServicelmpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;

    //查询
    @Override
    public List<Visitor> findAll() {
        return visitorMapper.findAll();
    }

    //添加
    @Override
    public void AddViS(Visitor visitor) {
        visitorMapper.AddViS(visitor);
    }

    //删除
    @Override
    public void deleteVisById(List<Integer> ids) {
        visitorMapper.deleteVisById(ids);
    }
}
