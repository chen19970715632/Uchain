package com.example.uchain.mapper;

import com.example.uchain.demo.UpdateWorks;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UpdateWorksMapper {

    //查询
    @Select("select * from update_works")
    List<UpdateWorks> findAll();

    //添加
    @Insert("insert into update_works (works_type,works_file,work_id)" +
            " values(#{worksType},#{worksFile},#{workId})")
    void AddUpdate(UpdateWorks updateWorks);

    //批量删除
    void deleteUpdateById(@Param("workIds")List<Integer> workIds);

    //根据id然后修改商品信息
    void updateById(UpdateWorks updateWorks);
}
