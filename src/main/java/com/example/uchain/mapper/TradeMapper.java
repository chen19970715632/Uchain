package com.example.uchain.mapper;

import com.example.uchain.demo.Trade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TradeMapper {

    //分页查询 未购买
    List<Trade> findAll(
            @Param("ownerName") String ownerName,
            @Param("workName") String workName,
            @Param("CRId") Integer CRId,
            @Param("workType") String workType,
            @Param("authorization") String authorization,
            @Param("blockAddress") String blockAddress,
            @Param("code") Integer code);

    //添加
    @Insert("insert into trade (ownerName, ownerContact, workName, workType, tradingTime, blockAddress, certificateFile, CRId, authorization, price, PurchaseState, FavoritesState,treadTime,isExpand,uid)"+
            " values(#{ownerName},#{ownerContact},#{workName},#{workType},#{tradingTime},#{blockAddress},#{certificateFile},#{CRId},#{authorization},#{price},#{PurchaseState},#{FavoritesState},#{treadTime},#{isExpand},#{uid})")
    void AddTrade(Trade trade);

    //删除
    void deleteTradeById(@Param("CRIds") List<Integer> CRIds);

    //修改
    void updateById(Trade trade);

    //修改购买状态
    void updateById1(Trade trade);

    //修改收藏状态
    void updateById2(Trade trade);

    @Select("select * from trade where CRId =#{CRId}")
    List<Trade> findAll1(Integer CRId);


    //分页查询 已收藏
    List<Trade> findAll2(
            @Param("ownerName") String ownerName,
            @Param("workName") String workName,
            @Param("CRId") Integer CRId,
            @Param("workType") String workType,
            @Param("authorization") String authorization,
            @Param("blockAddress") String blockAddress,
            @Param("code") Integer code);

    //分页查询 已收藏 未购买
    List<Trade> findAll3(
            @Param("ownerName") String ownerName,
            @Param("workName") String workName,
            @Param("CRId") Integer CRId,
            @Param("workType") String workType,
            @Param("authorization") String authorization,
            @Param("blockAddress") String blockAddress,
            @Param("code") Integer code,
            @Param("uid") Integer uid);

    //分页查询 已收藏 已购买
    List<Trade> findAll4(
            @Param("ownerName") String ownerName,
            @Param("workName") String workName,
            @Param("CRId") Integer CRId,
            @Param("workType") String workType,
            @Param("authorization") String authorization,
            @Param("blockAddress") String blockAddress,
            @Param("code") Integer code,
            @Param("uid") Integer uid);

    //分页查询  已购买
    List<Trade> findAll5(
            @Param("ownerName") String ownerName,
            @Param("workName") String workName,
            @Param("CRId") Integer CRId,
            @Param("workType") String workType,
            @Param("authorization") String authorization,
            @Param("blockAddress") String blockAddress,
            @Param("code") Integer code,
            @Param("uid") Integer uid);

    //修改收藏状态
    void updateById3(Trade trade);

    //查询热门权益人
    @Select("SELECT ownerName,ownerContact, COUNT(ownerName) AS nameCount\n" +
            "FROM trade\n" +
            "GROUP BY ownerName,ownerContact\n" +
            "ORDER BY nameCount DESC\n" +
            "LIMIT 10")
    List<Trade> findAllPeople();

//    根据uid查询交易信息
    @Select("select * from trade where uid =#{uid}")
    List<Trade> tradeFindByUid(Integer uid);
}
