package com.example.uchain.service;

import com.example.uchain.demo.UpdateWorks;

import java.util.List;

public interface UpdateWorksService {

    List<UpdateWorks> findAll();

    void AddUpdate(UpdateWorks updateWorks);

    void deleteUpdateById(List<Integer> workIds);

    void updateById(UpdateWorks updateWorks);
}
