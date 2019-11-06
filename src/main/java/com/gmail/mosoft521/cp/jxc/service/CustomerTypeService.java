package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.CustomerType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerTypeService {

    List<CustomerType> list();

    @Transactional
    boolean saveOrUpdate(CustomerType customerType);

    @Transactional
    boolean delete(Integer customerTypeId);

    String getNameById(Integer customerTypeId);
}