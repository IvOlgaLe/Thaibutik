package com.myapp.model;

import java.util.List;

public class Product extends BaseEntity {
    private String	name;
    private Brand brand;
    private String	imageSource;
    private String	description;
    private List<Category> categoryList;


    public Product() {

    }

    public Product(Integer id, String name, Brand brand, String imageSource, String description, List<Category> categoryList) {
        super(id);
        this.name = name;
        this.brand = brand;
        this.imageSource = imageSource;
        this.description = description;
        this.categoryList = categoryList;
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}


