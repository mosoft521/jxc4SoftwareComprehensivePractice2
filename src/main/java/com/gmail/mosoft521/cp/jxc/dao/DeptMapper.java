package com.gmail.mosoft521.cp.jxc.dao;

import com.gmail.mosoft521.cp.jxc.entity.Dept;
import com.gmail.mosoft521.cp.jxc.entity.DeptExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}