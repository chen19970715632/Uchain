package com.example.uchain.service.impl;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;
import com.example.uchain.mapper.ArchorMapper;
import com.example.uchain.service.ArchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArchorServicelmpl implements ArchorService {

    @Autowired
    private ArchorMapper archorMapper;

    @Override
    public List<Archor> findAll() {
        return archorMapper.findAll();
    }

    @Override
    public void AddArchor(Archor archor) {
        archor.setUpdateTime(LocalDateTime.now());
        archorMapper.AddArchor(archor);
    }

    @Override
    public void deleteArchorById(List<Integer> memberIds) {
        archorMapper.deleteArchorById(memberIds);
    }

    @Override
    public void updateById(Archor archor) {
        archor.setUpdateTime(LocalDateTime.now());
        archorMapper.updateById(archor);
    }
}
