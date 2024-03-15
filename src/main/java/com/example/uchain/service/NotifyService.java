package com.example.uchain.service;

import com.example.uchain.demo.Notify;

import java.util.List;

public interface NotifyService {
    List<Notify> findAll();

    void AddNOti(Notify notify);

    void deleteNOtiById(List<Integer> ids);

    void updateById(Notify notify);
}
