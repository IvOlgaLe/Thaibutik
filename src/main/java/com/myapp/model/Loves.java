package com.myapp.model;

public class Loves extends BaseEntity{
    private User user;
    private Product product;

    public Loves() {

    }

    public Loves(Integer id, User user, Product product) {
        super(id);
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
