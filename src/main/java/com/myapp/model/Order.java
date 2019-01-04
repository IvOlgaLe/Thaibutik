package com.myapp.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order extends BaseEntity{
    private int userId;
    private Date orderDate;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private int currencyId;
    private Date deliveryDate;
    private String deliveryInfo;
    private OrderState orderState;
    private String deliveryAddress;
    private List<OrderDetail> orderDetailList;

    public Order() {}

    public Order( int userId, Date orderDate, BigDecimal totalPrice, int totalQuantity, int currencyId, Date deliveryDate,
                 String deliveryInfo, OrderState orderState, String deliveryAddress, List<OrderDetail> orderDetailList) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.currencyId = currencyId;
        this.deliveryDate = deliveryDate;
        this.deliveryInfo = deliveryInfo;
        this.orderState = orderState;
        this.deliveryAddress = deliveryAddress;
        this.orderDetailList = orderDetailList;
    }

    public Order(Integer id, int userId, Date orderDate, BigDecimal totalPrice,int totalQuantity, int currencyId, Date deliveryDate,
                 String deliveryInfo, OrderState orderState, String deliveryAddress, List<OrderDetail> orderDetailList) {
        super(id);
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.currencyId = currencyId;
        this.deliveryDate = deliveryDate;
        this.deliveryInfo = deliveryInfo;
        this.orderState = orderState;
        this.deliveryAddress = deliveryAddress;
        this.orderDetailList = orderDetailList;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return userId == order.userId &&
                currencyId == order.currencyId &&
                orderDate.compareTo(order.orderDate) == 0 &&
                totalPrice.compareTo(order.totalPrice) == 0 &&
                totalQuantity == order.totalQuantity &&
                (deliveryDate.compareTo(order.deliveryDate) == 0 || (deliveryDate == null && order.deliveryDate == null)) &&
                (Objects.equals(deliveryAddress, order.deliveryAddress) || (deliveryAddress == null && order.deliveryAddress == null))&&
                (Objects.equals(deliveryInfo, order.deliveryInfo) || (deliveryInfo == null && order.deliveryInfo == null))&&
                Objects.equals(orderState, order.orderState) &&
                Objects.equals(orderDetailList.size(), order.orderDetailList.size()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, orderDate, totalPrice, totalQuantity, currencyId, deliveryDate, deliveryInfo, orderState, deliveryAddress, orderDetailList);
    }
}
