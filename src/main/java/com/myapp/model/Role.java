package com.myapp.model;

public class Role extends BaseEntity{
    private String name;

    public Role() {

    }

    public Role(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String roleName) {
        this.name = roleName;
    }
}
