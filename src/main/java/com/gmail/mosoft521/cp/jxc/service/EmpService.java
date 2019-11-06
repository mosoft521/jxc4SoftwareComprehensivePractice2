package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Emp;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpService {
    @Transactional
    boolean login(String userName, String password);

    List<Emp> list();

    @Transactional
    boolean saveOrUpdate(Emp emp);

    @Transactional
    boolean delete(Integer empId);

    String getNameById(Integer empId);
}
