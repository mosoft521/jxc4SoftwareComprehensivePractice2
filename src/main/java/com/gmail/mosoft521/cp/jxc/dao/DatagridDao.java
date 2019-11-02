package com.gmail.mosoft521.cp.jxc.dao;
import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatagridDao {

    public List<Datagrid> findAll();

    public boolean saveOrUpdate(Datagrid datagrid);

    public boolean delete(Integer id);
}