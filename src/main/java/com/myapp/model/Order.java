package com.myapp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private Date orderDate;
    private BigDecimal totalPrice;
    private List<OrderDetail> orderDetailList;
    private Date deliveryDate;
    private String deliveryInfo;
    private int orderState;

    public Order() {}

    public Order(int orderId, int userId, Date orderDate, BigDecimal totalPrice, List<OrderDetail> orderDetailList,
                 Date deliveryDate, String deliveryInfo, int orderState) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderDetailList = orderDetailList;
        this.deliveryDate = deliveryDate;
        this.deliveryInfo = deliveryInfo;
        this.orderState = orderState;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
}
