package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.PurchaseMapper;
import com.gmail.mosoft521.cp.jxc.entity.Purchase;
import com.gmail.mosoft521.cp.jxc.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> list() {
        return purchaseMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Purchase purchase) {
        int r = 0;
        if (null == purchase.getPurchaseId()) {
            r = purchaseMapper.insertSelective(purchase);
        } else {
            r = purchaseMapper.updateByPrimaryKey(purchase);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer purchaseId) {
        return purchaseMapper.deleteByPrimaryKey(purchaseId) > 0 ? true : false;
    }

    @Override
    public String getNoById(Integer purchaseId) {
        return purchaseMapper.selectByPrimaryKey(purchaseId).getPurchaseNo();
    }

    @Override
    public Purchase getById(Integer purchaseId) {
        return purchaseMapper.selectByPrimaryKey(purchaseId);
    }
}
