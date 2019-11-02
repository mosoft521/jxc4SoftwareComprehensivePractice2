package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DatagridService {

    public List<Datagrid> list();

    @Transactional
    public boolean saveOrUpdate(Datagrid datagrid);

    @Transactional
    public boolean delete(Integer id);
}