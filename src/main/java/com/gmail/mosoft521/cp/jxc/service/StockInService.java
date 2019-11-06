package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.StockIn;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockInService {

    List<StockIn> list();

    @Transactional
    boolean saveOrUpdate(StockIn stockIn);

    @Transactional
    boolean delete(Integer stockInId);

    String getNameById(Integer stockInId);
}