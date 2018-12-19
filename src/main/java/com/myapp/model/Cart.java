package com.myapp.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class Cart extends BaseEntity{
    private int userId;
    private BigDecimal totalPrice;
    private Currency currency;
    private List<CartDetail> cartDetailList;
    private Date cartDate;

    public Cart() {}

    public Cart(Integer id, int userId, BigDecimal totalPrice, Currency currency, List<CartDetail> cartDetailList, Date cartDate) {
        super(id);
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.currency = currency;
        this.cartDetailList = cartDetailList;
        this.cartDate = cartDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    public Date getCartDate() {
        return cartDate;
    }

    public void setCartDate(Date cartDate) {
        this.cartDate = cartDate;
    }
}
