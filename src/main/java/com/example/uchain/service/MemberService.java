package com.example.uchain.service;

import com.example.uchain.demo.Member;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;

import java.util.List;

public interface MemberService {

    void AddMem(Member member);

    void deleteMemById(List<Integer> id);

    Result updateById(Member member);

    PageBean page(Integer Page, Integer pageSize, String userName, Short sex);

    Member login(Member member);

    List<Member> findAll1(Integer id);
}
