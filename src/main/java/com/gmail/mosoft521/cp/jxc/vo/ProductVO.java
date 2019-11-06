package com.gmail.mosoft521.cp.jxc.vo;

import com.gmail.mosoft521.cp.jxc.entity.Product;

public class ProductVO extends Product {
    private String warehouseName;

    public ProductVO() {
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
