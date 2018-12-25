package com.myapp.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item extends BaseEntity{
    private int productId;
    private BigDecimal price;
    private String itemType;
    private String itemSize;
    private int currencyId;
    private int	quantity;
    private int	quantOrdered;
    private String	imageSource;
    private double	discount;
    private boolean	isAvailable;

    public Item() {

    }

    public Item(int productId, BigDecimal price, String itemType, String itemSize, int currencyId, int quantity, int quantOrdered, String imageSource, double discount, boolean isAvailable) {
        this.productId = productId;
        this.price = price;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.currencyId = currencyId;
        this.quantity = quantity;
        this.quantOrdered = quantOrdered;
        this.imageSource = imageSource;
        this.discount = discount;
        this.isAvailable = isAvailable;
    }

    public Item(Integer id, int productId, BigDecimal price, String itemType, String itemSize, int currencyId, int quantity, int quantOrdered, String imageSource, double discount, boolean isAvailable) {
        super(id);
        this.productId = productId;
        this.price = price;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.currencyId = currencyId;
        this.quantity = quantity;
        this.quantOrdered = quantOrdered;
        this.imageSource = imageSource;
        this.discount = discount;
        this.isAvailable = isAvailable;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return productId == item.productId &&
                currencyId == item.currencyId &&
                quantity == item.quantity &&
                quantOrdered == item.quantOrdered &&
                Double.compare(item.discount, discount) == 0 &&
                isAvailable == item.isAvailable &&
                Objects.equals(price, item.price) &&
                (Objects.equals(itemType, item.itemType) || (getItemType() == null && item.getItemType() == null)) &&
                (Objects.equals(itemSize, item.itemSize) || (getItemSize() == null && item.getItemSize() == null))&&
                (Objects.equals(imageSource, item.imageSource) || (getImageSource() == null && item.getImageSource() == null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productId, price, itemType, itemSize, currencyId, quantity, quantOrdered, imageSource, discount, isAvailable);
    }
}
