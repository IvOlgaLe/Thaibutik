package com.myapp.model;

public class OrderState extends BaseEntity{
    private String name;

    public OrderState() {

    }

    public OrderState(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
