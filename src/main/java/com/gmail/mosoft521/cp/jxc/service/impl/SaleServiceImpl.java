package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.SaleMapper;
import com.gmail.mosoft521.cp.jxc.entity.Sale;
import com.gmail.mosoft521.cp.jxc.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sale> list() {
        return saleMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Sale sale) {
        int r = 0;
        if (null == sale.getSaleId()) {
            r = saleMapper.insertSelective(sale);
        } else {
            r = saleMapper.updateByPrimaryKey(sale);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer saleId) {
        return saleMapper.deleteByPrimaryKey(saleId) > 0 ? true : false;
    }

    @Override
    public String getNoById(Integer saleId) {
        return saleMapper.selectByPrimaryKey(saleId).getSaleNo();
    }

    @Override
    public Sale getById(Integer saleId) {
        return saleMapper.selectByPrimaryKey(saleId);
    }
}
