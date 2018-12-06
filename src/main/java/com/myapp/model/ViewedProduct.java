package com.myapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class ViewedProduct {
    private int userId;
    private int productId;
    private Date activeDate;
    private String product;
    private String imageSource;
    private BigDecimal price;
    private double discount;

    public ViewedProduct() {

    }

    public ViewedProduct(int userId, int productId, Date activeDate, String product,
                         String imageSource, BigDecimal price, double discount) {
        this.userId = userId;
        this.productId = productId;
        this.activeDate = activeDate;
        this.product = product;
        this.imageSource = imageSource;
        this.price = price;
        this.discount = discount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
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
}
