package com.example.uchain.mapper;

import com.example.uchain.demo.Author;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorMapper {

    //查询
    @Select("select * from author")
    public List<Author> findAll();

    //添加
    @Insert("insert into author (name,id_type,id_number,phone_number,mail,id_start_time,id_end_time,update_time,if_longterm)" +
            " values(#{name},#{idType},#{idNumber},#{phoneNumber},#{mail},#{idStartTime},#{idEndTime},#{updateTime},#{ifLongterm})")
    public void AddAuthor(Author author) ;


    //批量删除
    public void deleteAuthorById(@Param("memberIds") List<Integer> memberIds) ;

    //根据id然后修改商品信息
    public void updateById(Author author) ;

}
