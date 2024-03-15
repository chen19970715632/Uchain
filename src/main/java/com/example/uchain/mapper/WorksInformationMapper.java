package com.example.uchain.mapper;

import com.example.uchain.demo.Member;
import com.example.uchain.demo.WorksInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorksInformationMapper {

    //查询
    @Select("select * from works_information")
    List<WorksInformation> findAll();


    //添加
    @Insert("insert into works_information (works_name,works_property,create_time,introduce,create_address,publish_state,firstpublish_time,publish_address,w_id)" +
            " values(#{worksName},#{worksProperty},#{createTime},#{introduce},#{createAddress},#{publishState},#{firstpublishTime},#{publishAddress},#{wid})")
    void AddInformation(WorksInformation worksInformation);

    //批量删除
    void deleteInformationById(@Param("wids") List<Integer> wids);

    //根据id然后修改商品信息
    void updateById(WorksInformation worksInformation);

    //带条件的分页查询
    List<WorksInformation> findAll1(@Param("worksName") String worksName,
                                    @Param("worksProperty")String worksProperty,
                                    @Param("publishAddress")String publishAddress,
                                    @Param("publishState") String publishState,
                                    @Param("createAddress")String createAddress,
                                    @Param("wid")Integer wid,
                                    @Param("code")Integer code);
}
