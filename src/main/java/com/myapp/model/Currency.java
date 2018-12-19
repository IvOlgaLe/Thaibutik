package com.myapp.model;

public class Currency extends BaseEntity{
    private String name;
    private String description;

    public Currency() {

    }

    public Currency(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String roleName) {
        this.name = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
