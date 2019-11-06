package com.gmail.mosoft521.cp.jxc.vo;

import com.gmail.mosoft521.cp.jxc.entity.Stock;

public class StockVO extends Stock {
    private String productName;

    public StockVO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
