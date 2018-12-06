package com.myapp.model;

import java.math.BigDecimal;

public class CartDetail {
    private int cartId;
    private int productId;
    private String product;
    private String imageSource;
    private int quantity;
    private BigDecimal price;
    private double discount;
    private boolean savedForLater;

    public CartDetail() {

    }

    public CartDetail(int cartId, int productId, String product, String imageSource,
                      int quantity, BigDecimal price, double discount, boolean savedForLater) {
        this.cartId = cartId;
        this.productId = productId;
        this.product = product;
        this.imageSource = imageSource;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.savedForLater = savedForLater;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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

    public boolean isSavedForLater() {
        return savedForLater;
    }

    public void setSavedForLater(boolean savedForLater) {
        this.savedForLater = savedForLater;
    }
}
