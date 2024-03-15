package com.example.uchain.mapper;

import com.example.uchain.demo.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VisitorMapper {

    //查询
    @Select("select * from visitor")
    List<Visitor> findAll();

    //添加
    @Insert("insert into visitor (name,id)" +
            " values(#{name},#{id})")
    void AddViS(Visitor visitor);

    //删除
    void deleteVisById(@Param("ids") List<Integer> ids);
}
