package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.Stock;
import com.gmail.mosoft521.cp.jxc.entity.StockExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}