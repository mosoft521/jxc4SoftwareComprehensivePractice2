package com.gmail.mosoft521.cp.jxc.entity;

import java.util.Date;

public class StockOut {
    private String stockOutNo;

    private String saleNo;

    private Date day;

    private Integer quantity;

    private String remark;

    public String getStockOutNo() {
        return stockOutNo;
    }

    public void setStockOutNo(String stockOutNo) {
        this.stockOutNo = stockOutNo == null ? null : stockOutNo.trim();
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo == null ? null : saleNo.trim();
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