package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.CustomerTypeMapper;
import com.gmail.mosoft521.cp.jxc.entity.CustomerType;
import com.gmail.mosoft521.cp.jxc.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeMapper customerTypeMapper;

    @Override
    public List<CustomerType> list() {
        return customerTypeMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(CustomerType customerType) {
        int r = 0;
        if (null == customerType.getCustomerTypeId()) {
            r = customerTypeMapper.insertSelective(customerType);
        } else {
            r = customerTypeMapper.updateByPrimaryKey(customerType);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer customerTypeId) {
        return customerTypeMapper.deleteByPrimaryKey(customerTypeId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer customerTypeId) {
        return customerTypeMapper.selectByPrimaryKey(customerTypeId).getName();
    }
}
