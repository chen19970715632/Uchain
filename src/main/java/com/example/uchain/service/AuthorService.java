package com.example.uchain.service;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    void AddAuthor(Author author);

    void deleteAuthorById(List<Integer> memberIds);

    void updateById(Author author);
}
