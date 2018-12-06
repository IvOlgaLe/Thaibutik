package com.myapp.model;

import java.math.BigDecimal;

public class Product {
    private int	productId;
    private int localeId;
    private String	name;
    private BigDecimal price;
    private int	currencyId;
    private int	categoryId;
    private String	category;
    private int	brandId;
    private String	brand;
    private int	quantity;
    private int	quantOrdered;
    private String	imageSource;
    private String	description;
    private double	discount;

    public Product() {

    }

    public Product(int productId, int localeId, String name, BigDecimal price, int currencyId, int categoryId, String category,
                   int brandId, String brand, int quantity, int quantOrdered, String imageSource, String description, double discount) {
        this.productId = productId;
        this.localeId = localeId;
        this.name = name;
        this.price = price;
        this.currencyId = currencyId;
        this.categoryId = categoryId;
        this.category = category;
        this.brandId = brandId;
        this.brand = brand;
        this.quantity = quantity;
        this.quantOrdered = quantOrdered;
        this.imageSource = imageSource;
        this.description = description;
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getLocaleId() {
        return localeId;
    }

    public void setLocaleId(int localeId) {
        this.localeId = localeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
