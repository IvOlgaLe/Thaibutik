package com.myapp.enums;

public enum OrderStateEnum {
    PROCESSING("PROCESSING"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    private final String name;

    OrderStateEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
