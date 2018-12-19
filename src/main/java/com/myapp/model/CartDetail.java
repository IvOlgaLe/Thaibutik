package com.myapp.model;

public class CartDetail{
    private Cart cart;
    private Item item;
    private int quantity;

    public CartDetail() {}

    public CartDetail(Cart cart, Item item, int quantity) {
        this.cart = cart;
        this.item = item;
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
