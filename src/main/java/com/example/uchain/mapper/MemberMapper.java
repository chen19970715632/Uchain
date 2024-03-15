package com.example.uchain.mapper;

import com.example.uchain.demo.Member;
import com.example.uchain.demo.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface MemberMapper {


    //带条件的分页查询
    public List<Member> findAll(@Param("userName") String userName,
                                @Param("sex") Short sex);


    //添加会员信息
    //,create_time,update_time ,#{createTime},#{updateTime}
    @Insert("insert into member (user_name,sign,age,sex,phone_number,password,email,qq,wx,balance,blockAddress)" +
            " values(#{userName},#{sign},#{age},#{sex},#{phoneNumber},#{password},#{email},#{qq},#{wx},#{balance},#{blockAddress})")
    void AddMem(Member member);

    //根据id批量删除会员信息 (管理员才可以)
    Result deleteMemById(@Param("ids")List<Integer> ids);


    //根据id然后修改会员信息
    boolean updateById(Member member);


    @Select("select * from member where user_name =#{userName} and password =#{password}")
    Member login(Member member);

    //根据id查询所有信息
    @Select("select * from member where id =#{id}")
    List<Member> findAll1(@Param("id") Integer id);
}
