package com.example.uchain.mapper;

import com.example.uchain.demo.Works;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorksMapper {

    //查询
    @Select("select * from works")
    List<Works> findAll();

    //添加
    @Insert("insert into works (name,archor_id)" +
            " values(#{name},#{archorId})")
    void AddWork(Works works);

    //批量删除
    void deleteWorkById(@Param("ids")List<Integer> ids);

    //根据id然后修改商品信息
    void updateById(Works works);
}
