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
    private OrderState orderState;

    public Order() {}

}
