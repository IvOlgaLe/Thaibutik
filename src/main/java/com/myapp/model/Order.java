package com.myapp.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class Order extends BaseEntity{
    private int userId;
    private Date orderDate;
    private BigDecimal totalPrice;
    private Currency currency;
    private List<OrderDetail> orderDetailList;
    private Date deliveryDate;
    private String deliveryInfo;
    private OrderState orderState;

    public Order() {}

    public Order(Integer id, int userId, Date orderDate, BigDecimal totalPrice, Currency currency, List<OrderDetail> orderDetailList,
                 Date deliveryDate, String deliveryInfo, OrderState orderState) {
        super(id);
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.currency = currency;
        this.orderDetailList = orderDetailList;
        this.deliveryDate = deliveryDate;
        this.deliveryInfo = deliveryInfo;
        this.orderState = orderState;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
