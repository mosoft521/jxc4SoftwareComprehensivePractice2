package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.EmpMapper;
import com.gmail.mosoft521.cp.jxc.entity.EmpExample;
import com.gmail.mosoft521.cp.jxc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
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
}
