package com.gmail.mosoft521.cp.jxc.entity;

import java.util.Date;

public class StockIn {
    private String stockInNo;

    private String purchaseNo;

    private Date day;

    private Integer quantity;

    private String remark;

    public String getStockInNo() {
        return stockInNo;
    }

    public void setStockInNo(String stockInNo) {
        this.stockInNo = stockInNo == null ? null : stockInNo.trim();
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
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