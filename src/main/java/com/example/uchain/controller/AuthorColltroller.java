package com.example.uchain.controller;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;
import com.example.uchain.demo.Result;
import com.example.uchain.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j//日志用的注解
public class AuthorColltroller {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public Result findAll() {
        log.info("查看所有著作人信息");
        List<Author> goodsList = authorService.findAll();
        return Result.success(goodsList);
    }

    @PostMapping("/author")
    public Result AddAuthor(@RequestBody Author author){

        log.info("新增著作人信息: {}",author);
        authorService.AddAuthor(author);
        return Result.success();
    }

    @DeleteMapping("author/{memberIds}")
    public Result deleteAuthorById(@PathVariable("memberIds") List<Integer> memberIds){
        log.info("根据id批量删除著作人信息: {}",memberIds);
        authorService.deleteAuthorById(memberIds);
        return Result.success();
    }

    @PutMapping( "/author")
    public Result updateById(@RequestBody Author author){
        log.info("修改著作人信息: {}", author);
        authorService.updateById(author);
        return Result.success();
    }


}
