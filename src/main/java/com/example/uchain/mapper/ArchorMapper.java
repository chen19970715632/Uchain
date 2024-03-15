package com.example.uchain.mapper;

import com.example.uchain.demo.Archor;
import com.example.uchain.demo.Author;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArchorMapper {

    //查询
    @Select("select * from archor")
    public List<Archor> findAll();

    //添加
    @Insert("insert into archor (kind,name,id_type,id_number,create_time,end_time,update_time,member_id,if_longterm,address)" +
            " values(#{kind},#{name},#{idType},#{idNumber},#{createTime},#{endTime},#{updateTime},#{memberId},#{ifLongterm},#{address})")
    public void AddArchor(Archor archor);

    //批量删除
    public void deleteArchorById(@Param("memberIds") List<Integer> memberIds) ;

    //根据id然后修改商品信息
    public void updateById(Archor archor) ;
}
