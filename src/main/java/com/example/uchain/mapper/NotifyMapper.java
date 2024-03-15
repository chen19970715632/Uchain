package com.example.uchain.mapper;

import com.example.uchain.demo.Notify;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotifyMapper {
    //查询
    @Select("select * from notify")
    List<Notify> findAll();

    //添加
    @Insert("insert into notify (message,notify_people,notified_people,time)" +
            " values(#{message},#{notifyPeople},#{notifiedPeople},#{time})")
    void AddGood(Notify notify);

    //批量删除
    void deleteNOtiById(@Param("ids") List<Integer> ids);

    //根据id然后修改信息
    void updateById(Notify notify);
}
