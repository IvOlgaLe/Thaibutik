package com.myapp.DAOinterface;

import com.myapp.model.Cart;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CartDAOI {
    enum SQL {
        UPDATE_CART_BY_ID("UPDATE cart SET user_id=:user_id, cart_date=:cart_date, total_price=:total_price, " +
                "currency_id:=currency_id WHERE id=:id"),
        GET_CART_BY_ID("SELECT * FROM cart WHERE id = ?"),
        GET_CART_BY_USER_ID("SELECT * FROM cart WHERE user_id = ?"),
        GET_CART_BY_DATE("SELECT * FROM cart WHERE cart_date BETWEEN ? AND ?"),
        GET_ALL_CARTS("SELECT * FROM cart"),
        DELETE_CART_BY_ID("DELETE FROM cart WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    Cart saveCart(Cart cart);

    boolean deleteCartById(int id);

    List<Cart> getAllCarts();

    Cart getCartById(int id);

    List<Cart> getCartByUserId(int UserId);

    List<Cart> getCartByDate(Date fDate, Date sDate);

    List<Cart> getCartsByParam(Map<String, String> param);


}
