package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.EmpMapper;
import com.gmail.mosoft521.cp.jxc.entity.Emp;
import com.gmail.mosoft521.cp.jxc.entity.EmpExample;
import com.gmail.mosoft521.cp.jxc.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public boolean login(String userName, String password) {
        EmpExample example = new EmpExample();
        EmpExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        long count = empMapper.countByExample(example);
        return count > 0;
    }

    @Override
    public List<Emp> list() {
        return empMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Emp emp) {
        int r = 0;
        if (null == emp.getEmpId()) {
            r = empMapper.insertSelective(emp);
        } else {
            r = empMapper.updateByPrimaryKey(emp);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer empId) {
        return empMapper.deleteByPrimaryKey(empId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer empId) {
        return empMapper.selectByPrimaryKey(empId).getName();
    }
}
