package com.gmail.mosoft521.cp.jxc.entity;

public class Stock {
    private String productNo;

    private Float quantityCurrent;

    private Float quantityMin;

    private Float quantityMax;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public Float getQuantityCurrent() {
        return quantityCurrent;
    }

    public void setQuantityCurrent(Float quantityCurrent) {
        this.quantityCurrent = quantityCurrent;
    }

    public Float getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(Float quantityMin) {
        this.quantityMin = quantityMin;
    }

    public Float getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(Float quantityMax) {
        this.quantityMax = quantityMax;
    }
}