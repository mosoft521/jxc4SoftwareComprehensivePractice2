package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.CustomerMapper;
import com.gmail.mosoft521.cp.jxc.entity.Customer;
import com.gmail.mosoft521.cp.jxc.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> list() {
        return customerMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Customer customer) {
        int r = 0;
        if (null == customer.getCustomerId()) {
            r = customerMapper.insertSelective(customer);
        } else {
            r = customerMapper.updateByPrimaryKey(customer);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer customerId) {
        return customerMapper.deleteByPrimaryKey(customerId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId).getName();
    }
}
