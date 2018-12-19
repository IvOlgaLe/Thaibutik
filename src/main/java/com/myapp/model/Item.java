package com.myapp.model;

import java.math.BigDecimal;

public class Item extends BaseEntity{
    private Product	product;
    private BigDecimal price;
    private String itemType;
    private String itemSize;
    private Currency currency;
    private int	quantity;
    private int	quantOrdered;
    private String	imageSource;
    private double	discount;
    private boolean	isAvailable;

    public Item() {

    }

    public Item(Integer id, Product product, BigDecimal price, String itemType, String itemSize, Currency currency, int quantity, int quantOrdered, String imageSource, double discount, boolean isAvailable) {
        super(id);
        this.product = product;
        this.price = price;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.currency = currency;
        this.quantity = quantity;
        this.quantOrdered = quantOrdered;
        this.imageSource = imageSource;
        this.discount = discount;
        this.isAvailable = isAvailable;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantOrdered() {
        return quantOrdered;
    }

    public void setQuantOrdered(int quantOrdered) {
        this.quantOrdered = quantOrdered;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
