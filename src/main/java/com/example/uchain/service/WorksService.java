package com.example.uchain.service;

import com.example.uchain.demo.Works;

import java.util.List;

public interface WorksService {
    List<Works> findAll();

    void AddWork(Works works);

    void deleteWorkById(List<Integer> ids);

    void updateById(Works works);
}
