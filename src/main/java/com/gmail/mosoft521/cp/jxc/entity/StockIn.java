package com.gmail.mosoft521.cp.jxc.entity;

import java.util.Date;

public class StockIn {
    private Integer stockInId;

    private String stockInNo;

    private Integer purchaseId;

    private Date day;

    private Integer quantity;

    private String remark;

    public Integer getStockInId() {
        return stockInId;
    }

    public void setStockInId(Integer stockInId) {
        this.stockInId = stockInId;
    }

    public String getStockInNo() {
        return stockInNo;
    }

    public void setStockInNo(String stockInNo) {
        this.stockInNo = stockInNo == null ? null : stockInNo.trim();
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
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