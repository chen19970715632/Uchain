package com.example.uchain.service;

import com.example.uchain.demo.Visitor;

import java.util.List;

public interface VisitorService {

    List<Visitor> findAll();

    void AddViS(Visitor visitor);

    void deleteVisById(List<Integer> ids);
}
