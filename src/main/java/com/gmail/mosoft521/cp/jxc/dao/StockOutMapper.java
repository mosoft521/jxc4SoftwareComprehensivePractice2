package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.StockOut;
import com.gmail.mosoft521.cp.jxc.entity.StockOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockOutMapper {
    long countByExample(StockOutExample example);

    int deleteByExample(StockOutExample example);

    int deleteByPrimaryKey(String stockOutNo);

    int insert(StockOut record);

    int insertSelective(StockOut record);

    List<StockOut> selectByExample(StockOutExample example);

    StockOut selectByPrimaryKey(String stockOutNo);

    int updateByExampleSelective(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByExample(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByPrimaryKeySelective(StockOut record);

    int updateByPrimaryKey(StockOut record);
}