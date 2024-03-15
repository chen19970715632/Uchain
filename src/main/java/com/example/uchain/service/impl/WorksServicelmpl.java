package com.example.uchain.service.impl;

import com.example.uchain.demo.Works;
import com.example.uchain.mapper.WorksMapper;
import com.example.uchain.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServicelmpl implements WorksService {

    @Autowired
    private WorksMapper worksMapper;

    @Override
    public List<Works> findAll() {
        return worksMapper.findAll();
    }

    @Override
    public void AddWork(Works works) {
        worksMapper.AddWork(works);
    }

    @Override
    public void deleteWorkById(List<Integer> ids) {
        worksMapper.deleteWorkById(ids);
    }

    @Override
    public void updateById(Works works) {
        worksMapper.updateById(works);
    }
}
