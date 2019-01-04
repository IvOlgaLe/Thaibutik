package com.myapp.model;

import java.util.List;

public class Group extends BaseEntity{
    private String	name;
    private String	description;
    List<Category> categoryList;

    public Group() {

    }
    public Group(String name, String description, List<Category> categoryList) {
        this.name = name;
        this.description = description;
        this.categoryList = categoryList;
    }
    public Group(Integer id, String name, String description, List<Category> categoryList) {
        super(id);
        this.name = name;
        this.description = description;
        this.categoryList = categoryList;
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
