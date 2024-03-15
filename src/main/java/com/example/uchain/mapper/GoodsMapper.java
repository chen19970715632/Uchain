package com.example.uchain.mapper;

import com.example.uchain.demo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    //查询
    @Select("select * from goods")
    List<Goods> findAll();


    //添加
    @Insert("insert into goods (price,works_id,name,id,block_number)" +
            " values(#{price},#{worksId},#{name},#{id},#{blockNumber})")
    void AddGood(Goods goods);

    //批量删除
    void deleteGoodById(@Param("ids") List<Integer> ids);


    //根据id然后修改商品信息
    void updateById(Goods goods);
}
