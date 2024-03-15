package com.example.uchain.service.impl;

import com.example.uchain.demo.Notify;
import com.example.uchain.mapper.NotifyMapper;
import com.example.uchain.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotifyServicelmpl implements NotifyService {
    @Autowired
    private NotifyMapper notifyMapper;

    //查询
    @Override
    public List<Notify> findAll() {
        return notifyMapper.findAll();
    }

    //添加
    @Override
    public void AddNOti(Notify notify) {
        notify.setTime(LocalDateTime.now());
        notifyMapper.AddGood(notify);
    }

    //删除
    @Override
    public void deleteNOtiById(List<Integer> ids) {
        notifyMapper.deleteNOtiById(ids);
    }

    //修改
    @Override
    public void updateById(Notify notify) {
        notifyMapper.updateById(notify);
    }
}
