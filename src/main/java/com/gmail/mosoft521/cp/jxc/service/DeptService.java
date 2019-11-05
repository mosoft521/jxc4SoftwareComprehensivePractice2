package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeptService {

    public List<Dept> list();

    @Transactional
    public boolean saveOrUpdate(Dept dept);

    @Transactional
    public boolean delete(Integer deptId);
}