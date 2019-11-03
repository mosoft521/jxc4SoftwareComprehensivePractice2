package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.StockIn;
import com.gmail.mosoft521.cp.jxc.entity.StockInExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockInMapper {
    long countByExample(StockInExample example);

    int deleteByExample(StockInExample example);

    int deleteByPrimaryKey(Integer stockInId);

    int insert(StockIn record);

    int insertSelective(StockIn record);

    List<StockIn> selectByExample(StockInExample example);

    StockIn selectByPrimaryKey(Integer stockInId);

    int updateByExampleSelective(@Param("record") StockIn record, @Param("example") StockInExample example);

    int updateByExample(@Param("record") StockIn record, @Param("example") StockInExample example);

    int updateByPrimaryKeySelective(StockIn record);

    int updateByPrimaryKey(StockIn record);
}