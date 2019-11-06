package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DatagridService {

    List<Datagrid> list();

    @Transactional
    boolean saveOrUpdate(Datagrid datagrid);

    @Transactional
    boolean delete(Integer id);
}