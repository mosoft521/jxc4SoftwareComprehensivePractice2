package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.EmpTypeMapper;
import com.gmail.mosoft521.cp.jxc.entity.EmpType;
import com.gmail.mosoft521.cp.jxc.service.EmpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpTypeServiceImpl implements EmpTypeService {

    @Autowired
    private EmpTypeMapper empTypeMapper;

    @Override
    public List<EmpType> list() {
        return empTypeMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(EmpType empType) {
        int r = 0;
        if (null == empType.getEmpTypeId()) {
            r = empTypeMapper.insertSelective(empType);
        } else {
            r = empTypeMapper.updateByPrimaryKey(empType);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer empTypeId) {
        return empTypeMapper.deleteByPrimaryKey(empTypeId) > 0 ? true : false;
    }
}
