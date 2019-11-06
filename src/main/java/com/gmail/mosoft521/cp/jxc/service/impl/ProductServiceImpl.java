package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.ProductMapper;
import com.gmail.mosoft521.cp.jxc.entity.Product;
import com.gmail.mosoft521.cp.jxc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        int r = 0;
        if (null == product.getProductId()) {
            r = productMapper.insertSelective(product);
        } else {
            r = productMapper.updateByPrimaryKey(product);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer productId) {
        return productMapper.deleteByPrimaryKey(productId) > 0 ? true : false;
    }
}
