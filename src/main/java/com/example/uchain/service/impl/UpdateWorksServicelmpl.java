package com.example.uchain.service.impl;

import com.example.uchain.demo.UpdateWorks;
import com.example.uchain.mapper.UpdateWorksMapper;
import com.example.uchain.service.UpdateWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateWorksServicelmpl implements UpdateWorksService {
    @Autowired
    private UpdateWorksMapper updateWorksMapper;

    @Override
    public List<UpdateWorks> findAll() {
        return updateWorksMapper.findAll();
    }

    @Override
    public void AddUpdate(UpdateWorks updateWorks) {
        updateWorksMapper.AddUpdate(updateWorks);
    }

    @Override
    public void deleteUpdateById(List<Integer> workIds) {
        updateWorksMapper.deleteUpdateById(workIds);
    }

    @Override
    public void updateById(UpdateWorks updateWorks) {
        updateWorksMapper.updateById(updateWorks);
    }
}
