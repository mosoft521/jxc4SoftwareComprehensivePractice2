package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.ProductMapper;
import com.gmail.mosoft521.cp.jxc.dao.StockMapper;
import com.gmail.mosoft521.cp.jxc.entity.Product;
import com.gmail.mosoft521.cp.jxc.entity.Stock;
import com.gmail.mosoft521.cp.jxc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Product> list() {
        return productMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        int r = 0;
        if (null == product.getProductId()) {
            r = productMapper.insertSelective(product);
            //顺便插入一份库存
            Stock stock = new Stock();
            stock.setProductId(product.getProductId());
            stock.setQuantityCurrent(0);
            stock.setQuantityMin(0);
            stock.setQuantityMax(Integer.MAX_VALUE);
            stockMapper.insert(stock);
        } else {
            r = productMapper.updateByPrimaryKey(product);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer productId) {
        //先删除库存
        stockMapper.deleteByPrimaryKey(productId);
        return productMapper.deleteByPrimaryKey(productId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer productId) {
        return productMapper.selectByPrimaryKey(productId).getProductName();
    }
}
