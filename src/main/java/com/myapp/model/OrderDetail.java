package com.myapp.model;

import java.math.BigDecimal;

public class OrderDetail extends BaseEntity{
    private Order order;
    private Item item;
    private int	quantity;
    private BigDecimal price;
    private Currency currency;
    private double	discount;

    public OrderDetail() {

    }

    public OrderDetail(Integer id, Order order, Item item, int quantity, BigDecimal price, Currency currency, double discount) {
        super(id);
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.discount = discount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
