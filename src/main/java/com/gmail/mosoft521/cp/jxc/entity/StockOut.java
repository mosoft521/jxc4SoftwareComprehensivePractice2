package com.gmail.mosoft521.cp.jxc.entity;

import java.util.Date;

public class StockOut {
    private Integer stockOutId;

    private String stockOutNo;

    private Integer saleId;

    private Date day;

    private Integer quantity;

    private String remark;

    public Integer getStockOutId() {
        return stockOutId;
    }

    public void setStockOutId(Integer stockOutId) {
        this.stockOutId = stockOutId;
    }

    public String getStockOutNo() {
        return stockOutNo;
    }

    public void setStockOutNo(String stockOutNo) {
        this.stockOutNo = stockOutNo == null ? null : stockOutNo.trim();
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}