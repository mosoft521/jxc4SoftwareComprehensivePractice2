package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.EmpType;
import com.gmail.mosoft521.cp.jxc.entity.EmpTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpTypeMapper {
    long countByExample(EmpTypeExample example);

    int deleteByExample(EmpTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmpType record);

    int insertSelective(EmpType record);

    List<EmpType> selectByExample(EmpTypeExample example);

    EmpType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmpType record, @Param("example") EmpTypeExample example);

    int updateByExample(@Param("record") EmpType record, @Param("example") EmpTypeExample example);

    int updateByPrimaryKeySelective(EmpType record);

    int updateByPrimaryKey(EmpType record);
}