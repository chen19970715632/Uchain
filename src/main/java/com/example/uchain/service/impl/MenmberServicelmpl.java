package com.example.uchain.service.impl;

import com.example.uchain.demo.Member;
import com.example.uchain.demo.PageBean;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.Trade;
import com.example.uchain.mapper.MemberMapper;
import com.example.uchain.service.MemberService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenmberServicelmpl implements MemberService {


    @Autowired
    private MemberMapper memberMapper;


    //分页查询
    @Override
    public PageBean page(Integer Page, Integer pageSize, String userName, Short sex) {
        //设置分页参数
        PageHelper.startPage(Page, pageSize);

        //执行查询
        List<Member> memberList = memberMapper.findAll(userName, sex);

        // 获取分页信息
        Page<Member> p = (Page<Member>)  memberList;

        //封装pageBean对象
        PageBean pageBean1 = new PageBean(p.getTotal(), p.getResult());
        return pageBean1;
    }

    //根据手机号跟密码登录验证
    @Override
    public Member login(Member member) {
        return memberMapper.login(member);
    }


    //添加
    @Override
    public void AddMem(Member member) {
        memberMapper.AddMem(member);
    }

    //删除
    @Override
    public void deleteMemById(List<Integer> ids) {
        memberMapper.deleteMemById(ids);
    }

    //修改
    @Override
    public Result updateById(Member member) {
        if (!memberMapper.updateById(member)){
          return Result.error("error，请确认id是否正确");
        }
        memberMapper.updateById(member);
        return Result.success();
    }

    //根据id查找数据
    @Override
    public List<Member> findAll1(Integer id) {

        return  memberMapper.findAll1(id);

    }
}
