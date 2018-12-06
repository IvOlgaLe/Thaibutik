package com.myapp.model;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    private int cartId;
    private int userId;
    private int sessionId;
    private BigDecimal totalPrice;
    private List<CartDetail> cartDetailList;

    public Cart() {

    }

    public Cart(int cartId, int userId, int sessionId, BigDecimal totalPrice, List<CartDetail> cartDetailList) {
        this.cartId = cartId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.totalPrice = totalPrice;
        this.cartDetailList = cartDetailList;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }
}
