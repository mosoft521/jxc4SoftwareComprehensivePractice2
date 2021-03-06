package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.PurchaseMapper;
import com.gmail.mosoft521.cp.jxc.dao.StockInMapper;
import com.gmail.mosoft521.cp.jxc.dao.StockMapper;
import com.gmail.mosoft521.cp.jxc.entity.Purchase;
import com.gmail.mosoft521.cp.jxc.entity.Stock;
import com.gmail.mosoft521.cp.jxc.entity.StockIn;
import com.gmail.mosoft521.cp.jxc.service.StockInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockInServiceImpl implements StockInService {

    @Resource
    private StockInMapper stockInMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private PurchaseMapper purchaseMapper;

    @Override
    public List<StockIn> list() {
        return stockInMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(StockIn stockIn) {
        int r = 0;
        if (null == stockIn.getStockInId()) {
            r = stockInMapper.insertSelective(stockIn);
            //更新一下库存
            int quantity = stockIn.getQuantity();
            Purchase purchase = purchaseMapper.selectByPrimaryKey(stockIn.getPurchaseId());
            Stock stock = stockMapper.selectByPrimaryKey(purchase.getProductId());
            stock.setQuantityCurrent(stock.getQuantityCurrent() + quantity);
            stockMapper.updateByPrimaryKeySelective(stock);
        } else {
            StockIn stockInOld = stockInMapper.selectByPrimaryKey(stockIn.getStockInId());
            int delta = stockIn.getQuantity() - stockInOld.getQuantity();
            r = stockInMapper.updateByPrimaryKey(stockIn);
            //更新一下库存
            int quantity = stockIn.getQuantity();
            Purchase purchase = purchaseMapper.selectByPrimaryKey(stockIn.getPurchaseId());
            Stock stock = stockMapper.selectByPrimaryKey(purchase.getProductId());
            stock.setQuantityCurrent(stock.getQuantityCurrent() + delta);
            stockMapper.updateByPrimaryKeySelective(stock);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer stockInId) {
        //更新库存
        StockIn stockIn = stockInMapper.selectByPrimaryKey(stockInId);
        Purchase purchase = purchaseMapper.selectByPrimaryKey(stockIn.getPurchaseId());
        Stock stock = stockMapper.selectByPrimaryKey(purchase.getProductId());
        stock.setQuantityCurrent(stock.getQuantityCurrent() - stockIn.getQuantity());
        stockMapper.updateByPrimaryKeySelective(stock);
        return stockInMapper.deleteByPrimaryKey(stockInId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer stockInId) {
        return stockInMapper.selectByPrimaryKey(stockInId).getStockInNo();
    }
}
