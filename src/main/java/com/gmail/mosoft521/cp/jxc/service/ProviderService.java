package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Provider;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProviderService {

    List<Provider> list();

    @Transactional
    boolean saveOrUpdate(Provider empType);

    @Transactional
    boolean delete(Integer warehouseId);
}