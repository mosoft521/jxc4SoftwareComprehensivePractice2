package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.StockOut;
import com.gmail.mosoft521.cp.jxc.entity.StockOutExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockOutMapper {
    long countByExample(StockOutExample example);

    int deleteByExample(StockOutExample example);

    int deleteByPrimaryKey(Integer stockInId);

    int insert(StockOut record);

    int insertSelective(StockOut record);

    List<StockOut> selectByExample(StockOutExample example);

    StockOut selectByPrimaryKey(Integer stockInId);

    int updateByExampleSelective(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByExample(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByPrimaryKeySelective(StockOut record);

    int updateByPrimaryKey(StockOut record);
}