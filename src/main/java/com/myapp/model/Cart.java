package com.myapp.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cart extends BaseEntity {
    private int userId;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private int currencyId;
    private Date cartDate;
    private List<CartDetail> cartDetailList;


    public Cart() {
    }

    public Cart(int userId, BigDecimal totalPrice, int totalQuantity, int currencyId, Date cartDate, List<CartDetail> cartDetailList) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.currencyId = currencyId;
        this.cartDate = cartDate;
        this.cartDetailList = cartDetailList;
    }

    public Cart(Integer id, int userId, BigDecimal totalPrice, int totalQuantity, int currencyId, Date cartDate, List<CartDetail> cartDetailList) {
        super(id);
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.currencyId = currencyId;
        this.cartDate = cartDate;
        this.cartDetailList = cartDetailList;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return userId == cart.userId &&
                currencyId == cart.currencyId &&
                totalPrice.compareTo(cart.totalPrice) == 0 &&
                totalQuantity == cart.totalQuantity &&
                cartDate.compareTo(cart.cartDate) == 0 &&
                Objects.equals(cartDetailList.size(), cart.cartDetailList.size());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, totalPrice, totalQuantity, currencyId, cartDate, cartDetailList);
    }
}
