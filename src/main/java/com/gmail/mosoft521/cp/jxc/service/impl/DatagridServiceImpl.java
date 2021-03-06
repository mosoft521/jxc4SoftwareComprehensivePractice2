package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.DatagridDao;
import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import com.gmail.mosoft521.cp.jxc.service.DatagridService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DatagridServiceImpl implements DatagridService {

    @Resource
    private DatagridDao datagridDao;

    @Override
    public List<Datagrid> list() {
        return datagridDao.findAll();
    }

    @Override
    public boolean saveOrUpdate(Datagrid datagrid) {
        return datagridDao.saveOrUpdate(datagrid);
    }

    @Override
    public boolean delete(Integer id) {
        return datagridDao.delete(id);
    }
}