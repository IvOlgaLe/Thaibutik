package com.myapp.model;

import java.math.BigDecimal;

public class OrderDetail {
    private int	orderId;
    private int	productId;
    private String	product;
    private String	imageSource;
    private int	quantity;
    private BigDecimal price;
    private double	discount;
    private int	orderStateId;
    private String	orderState;

    public OrderDetail() {

    }

    public OrderDetail(int orderId, int productId, String product, String imageSource, int quantity,
                       BigDecimal price, double discount, int orderStateId, String orderState) {
        this.orderId = orderId;
        this.productId = productId;
        this.product = product;
        this.imageSource = imageSource;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.orderStateId = orderStateId;
        this.orderState = orderState;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(int orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
