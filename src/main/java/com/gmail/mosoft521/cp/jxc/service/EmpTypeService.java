package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.EmpType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpTypeService {

    List<EmpType> list();

    @Transactional
    boolean saveOrUpdate(EmpType empType);

    @Transactional
    boolean delete(Integer empTypeId);
}