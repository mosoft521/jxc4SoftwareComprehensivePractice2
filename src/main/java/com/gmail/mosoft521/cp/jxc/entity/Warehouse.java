package com.gmail.mosoft521.cp.jxc.entity;

public class Warehouse {
    private String warehouseNo;

    private String warehouseName;

    private String warehouseAddress;

    private Integer warehouseSize;

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress == null ? null : warehouseAddress.trim();
    }

    public Integer getWarehouseSize() {
        return warehouseSize;
    }

    public void setWarehouseSize(Integer warehouseSize) {
        this.warehouseSize = warehouseSize;
    }
}