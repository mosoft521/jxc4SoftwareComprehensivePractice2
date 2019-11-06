package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.StockOut;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockOutService {

    List<StockOut> list();

    @Transactional
    boolean saveOrUpdate(StockOut stockOut);

    @Transactional
    boolean delete(Integer stockOutId);

    String getNameById(Integer stockOutId);
}