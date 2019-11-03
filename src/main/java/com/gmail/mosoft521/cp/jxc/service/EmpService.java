package com.gmail.mosoft521.cp.jxc.service;

import org.springframework.transaction.annotation.Transactional;

public interface EmpService {
    @Transactional
    boolean login(String userName, String password);
}
