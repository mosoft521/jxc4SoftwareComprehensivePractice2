package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeptService {

    List<Dept> list();

    @Transactional
    boolean saveOrUpdate(Dept dept);

    @Transactional
    boolean delete(Integer deptId);

    String getNameById(Integer deptId);
}