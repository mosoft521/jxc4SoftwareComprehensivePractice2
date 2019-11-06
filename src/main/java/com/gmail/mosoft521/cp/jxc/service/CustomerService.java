package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    List<Customer> list();

    @Transactional
    boolean saveOrUpdate(Customer empType);

    @Transactional
    boolean delete(Integer warehouseId);
}