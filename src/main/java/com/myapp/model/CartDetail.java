package com.myapp.model;

public class CartDetail{
    private int cartId;
    private Item item;
    private int quantity;

    public CartDetail() {}

    public CartDetail(int cartId, Item item, int quantity) {
        this.cartId = cartId;
        this.item = item;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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
