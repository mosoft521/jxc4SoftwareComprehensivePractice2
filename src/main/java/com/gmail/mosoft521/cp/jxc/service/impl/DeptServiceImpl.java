package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.DeptMapper;
import com.gmail.mosoft521.cp.jxc.entity.Dept;
import com.gmail.mosoft521.cp.jxc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Dept dept) {
        int r = 0;
        if (null == dept.getDeptId()) {
            r = deptMapper.insertSelective(dept);
        } else {
            r = deptMapper.updateByPrimaryKey(dept);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer deptId) {
        return deptMapper.deleteByPrimaryKey(deptId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer deptId) {
        return deptMapper.selectByPrimaryKey(deptId).getName();
    }
}
