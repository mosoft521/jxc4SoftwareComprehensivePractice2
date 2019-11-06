package com.gmail.mosoft521.cp.jxc.vo;

import com.gmail.mosoft521.cp.jxc.entity.StockOut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockOutVO extends StockOut {

    //日期格式
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String saleNo;

    private String customerName;

    private String empName;

    private String productName;

    private String strDay;

    public StockOutVO() {
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStrDay() {
        return dateFormat.format(super.getDay());
    }

    public void setStrDay(String strDay) {
        Date d = null;
        try {
            d = dateFormat.parse(strDay);
        } catch (ParseException e) {
            super.setDay(new Date());
        }
        super.setDay(d);
    }
}
