package com.myapp.cache;

public enum MemoryCache {
    ROLE("ROLE"),
    ORDER_STATE("ORDER_STATE");

    private final String name;

    MemoryCache(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
