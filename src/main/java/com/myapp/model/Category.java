package com.myapp.model;

import java.util.List;

public class Category extends BaseEntity{
    private String	name;
    private String	description;
    private List<Product> productList;

    public Category() {

    }

    public Category(Integer id, String name, String description, List<Product> productList) {
        super(id);
        this.name = name;
        this.description = description;
        this.productList=productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
