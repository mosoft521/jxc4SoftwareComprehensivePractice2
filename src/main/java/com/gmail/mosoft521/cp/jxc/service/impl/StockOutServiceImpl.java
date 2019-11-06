package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.SaleMapper;
import com.gmail.mosoft521.cp.jxc.dao.StockMapper;
import com.gmail.mosoft521.cp.jxc.dao.StockOutMapper;
import com.gmail.mosoft521.cp.jxc.entity.Sale;
import com.gmail.mosoft521.cp.jxc.entity.Stock;
import com.gmail.mosoft521.cp.jxc.entity.StockOut;
import com.gmail.mosoft521.cp.jxc.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOutServiceImpl implements StockOutService {

    @Autowired
    private StockOutMapper stockOutMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<StockOut> list() {
        return stockOutMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(StockOut stockOut) {
        int r = 0;
        if (null == stockOut.getStockOutId()) {
            r = stockOutMapper.insertSelective(stockOut);
            //更新一下库存
            int quantity = stockOut.getQuantity();
            Sale sale = saleMapper.selectByPrimaryKey(stockOut.getSaleId());
            Stock stock = stockMapper.selectByPrimaryKey(sale.getProductId());
            stock.setQuantityCurrent(stock.getQuantityCurrent() - quantity);
            stockMapper.updateByPrimaryKeySelective(stock);
        } else {
            StockOut stockOutOld = stockOutMapper.selectByPrimaryKey(stockOut.getStockOutId());
            int delta = stockOut.getQuantity() - stockOutOld.getQuantity();
            r = stockOutMapper.updateByPrimaryKey(stockOut);
            //更新一下库存
            int quantity = stockOut.getQuantity();
            Sale sale = saleMapper.selectByPrimaryKey(stockOut.getSaleId());
            Stock stock = stockMapper.selectByPrimaryKey(sale.getProductId());
            stock.setQuantityCurrent(stock.getQuantityCurrent() - delta);
            stockMapper.updateByPrimaryKeySelective(stock);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer stockOutId) {
        //更新库存
        StockOut stockOut = stockOutMapper.selectByPrimaryKey(stockOutId);
        Sale sale = saleMapper.selectByPrimaryKey(stockOut.getSaleId());
        Stock stock = stockMapper.selectByPrimaryKey(sale.getProductId());
        stock.setQuantityCurrent(stock.getQuantityCurrent() + stockOut.getQuantity());
        stockMapper.updateByPrimaryKeySelective(stock);
        return stockOutMapper.deleteByPrimaryKey(stockOutId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer stockOutId) {
        return stockOutMapper.selectByPrimaryKey(stockOutId).getStockOutNo();
    }
}
