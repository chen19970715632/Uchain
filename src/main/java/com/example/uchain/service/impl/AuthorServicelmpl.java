package com.example.uchain.service.impl;


import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;
import com.example.uchain.mapper.AuthorMapper;
import com.example.uchain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorServicelmpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public List<Author> findAll() {
        return authorMapper.findAll();
    }

    @Override
    public void AddAuthor(Author author) {
        author.setUpdateTime(LocalDateTime.now());
        authorMapper.AddAuthor(author);
    }

    @Override
    public void deleteAuthorById(List<Integer> memberIds) {
        authorMapper.deleteAuthorById(memberIds);
    }

    @Override
    public void updateById(Author author) {
        author.setUpdateTime(LocalDateTime.now());
        authorMapper.updateById(author);
    }
}
