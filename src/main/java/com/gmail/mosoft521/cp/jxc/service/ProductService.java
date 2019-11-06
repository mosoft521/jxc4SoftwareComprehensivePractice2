package com.gmail.mosoft521.cp.jxc.service;

import com.gmail.mosoft521.cp.jxc.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    List<Product> list();

    @Transactional
    boolean saveOrUpdate(Product product);

    @Transactional
    boolean delete(Integer productId);
}