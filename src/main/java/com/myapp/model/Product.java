package com.myapp.model;

import java.util.List;
import java.util.Objects;

public class Product extends BaseEntity {
    private String name;
    private Brand brand;
    private String imageSource;
    private String description;
    private List<Item> itemList;

    public Product() {

    }

    public Product(String name, Brand brand, String imageSource, String description, List<Item> itemList) {
        this.name = name;
        this.brand = brand;
        this.imageSource = imageSource;
        this.description = description;
        this.itemList = itemList;
    }

    public Product(Integer id, String name, Brand brand, String imageSource, String description, List<Item> itemList) {
        super(id);
        this.name = name;
        this.brand = brand;
        this.imageSource = imageSource;
        this.description = description;
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(brand.id, product.brand.id) &&
                (Objects.equals(imageSource, product.imageSource) || (getImageSource() == null && product.getImageSource() == null)) &&
                (Objects.equals(description, product.description) || (getDescription() == null && product.getDescription() == null))
               ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, brand, imageSource, description, itemList);
    }
}


