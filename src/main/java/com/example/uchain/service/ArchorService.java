package com.example.uchain.service;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;

import java.util.List;

public interface ArchorService {

    List<Archor> findAll();

    void AddArchor(Archor archor);

    void deleteArchorById(List<Integer> ids);

    void updateById(Archor archor);
}
