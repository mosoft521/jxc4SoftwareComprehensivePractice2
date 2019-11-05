package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Warehouse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> list();

    @Transactional
    boolean saveOrUpdate(Warehouse empType);

    @Transactional
    boolean delete(Integer warehouseId);
}