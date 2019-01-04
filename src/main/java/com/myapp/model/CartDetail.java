package com.myapp.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CartDetail {
    private int cartId;
    private int productId;
    private String productName;
    private String brandName;
    private int itemId;
    private String itemType;
    private String itemSize;
    private int quantity;
    private BigDecimal price;
    private int currencyId;
    private double discount;
    private String productImageSource;
    private String itemImageSource;

    public CartDetail() {
    }

    public CartDetail(int cartId, int productId, String productName, String brandName, int itemId, String itemType,
                      String itemSize, int quantity, BigDecimal price, int currencyId, double discount,
                      String productImageSource, String itemImageSource) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.itemId = itemId;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.quantity = quantity;
        this.price = price;
        this.currencyId = currencyId;
        this.discount = discount;
        this.productImageSource = productImageSource;
        this.itemImageSource = itemImageSource;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getProductImageSource() {
        return productImageSource;
    }

    public void setProductImageSource(String productImageSource) {
        this.productImageSource = productImageSource;
    }

    public String getItemImageSource() {
        return itemImageSource;
    }

    public void setItemImageSource(String itemImageSource) {
        this.itemImageSource = itemImageSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDetail that = (CartDetail) o;
        return cartId == that.cartId &&
                productId == that.productId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                currencyId == that.currencyId &&
                Double.compare(that.discount, discount) == 0 &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(brandName, that.brandName) &&
                (Objects.equals(itemType, that.itemType) || (itemType == null && that.itemType == null)) &&
                (Objects.equals(itemSize, that.itemSize) || (itemSize == null && that.itemSize == null)) &&
                price.compareTo(that.price) == 0 &&
                (Objects.equals(productImageSource, that.productImageSource) || (productImageSource == null && that.productImageSource == null)) &&
                (Objects.equals(itemImageSource, that.itemImageSource) || (itemImageSource == null && that.itemImageSource == null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId, productName, brandName, itemId, itemType, itemSize, quantity, price, currencyId, discount, productImageSource, itemImageSource);
    }
}
