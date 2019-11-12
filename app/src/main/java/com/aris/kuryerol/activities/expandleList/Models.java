package com.aris.kuryerol.activities.expandleList;

import java.time.LocalDate;

public class Models {
    private String orderNo;
    private String cafeName;
    private String cafePhoneNumber;
    private String cafeAddress;
    private LocalDate orderDate;

    public Models(String orderNo, String cafeName, String cafePhoneNumber, String cafeAddress, LocalDate orderDate) {
        this.orderNo = orderNo;
        this.cafeName = cafeName;
        this.cafePhoneNumber = cafePhoneNumber;
        this.cafeAddress = cafeAddress;
        this.orderDate = orderDate;
    }

    public Models() {
    }

    @Override
    public String toString() {
        return "Models{" +
                "orderNo='" + orderNo + '\'' +
                ", cafeName='" + cafeName + '\'' +
                ", cafePhoneNumber='" + cafePhoneNumber + '\'' +
                ", cafeAddress='" + cafeAddress + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getCafePhoneNumber() {
        return cafePhoneNumber;
    }

    public void setCafePhoneNumber(String cafePhoneNumber) {
        this.cafePhoneNumber = cafePhoneNumber;
    }

    public String getCafeAddress() {
        return cafeAddress;
    }

    public void setCafeAddress(String cafeAddress) {
        this.cafeAddress = cafeAddress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
