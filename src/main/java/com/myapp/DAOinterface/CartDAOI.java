package com.myapp.DAOinterface;

import com.myapp.model.Cart;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CartDAOI {
    enum SQL {
        UPDATE_CART_BY_ID("UPDATE cart SET user_id=:user_id, cart_date=:cart_date, total_price=:total_price, total_quantity=:total_quantity," +
                "currency_id=:currency_id WHERE id=:id"),
        GET_CART_BY_ID(
                "SELECT c.id AS cart_id, c.user_id AS user_id, c.cart_date AS cart_date, c.total_price AS total_price, c.total_quantity AS total_quantity, " +
                        "c.currency_id AS currency_id, cd.cart_id AS cd_cart_id, cd.quantity AS quantity, " +
                        "i.product_id AS product_id, i.id AS item_id, i.price AS price, i.currency_id AS item_currency_id, " +
                        "i.discount AS discount, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, i.image_source AS item_image_source, p.image_source AS product_image_source," +
                        "b.name AS brand_name " +
                        "FROM cart c " +
                        "LEFT JOIN cart_detail cd ON c.id = cd.cart_id " +
                        "LEFT JOIN item i ON cd.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE c.id = ?"),
        DELETE_CART_BY_ID("DELETE FROM cart WHERE id = ?"),
        GET_CART_BY_PARAM(
                "SELECT c.id AS cart_id, c.user_id AS user_id, c.cart_date AS cart_date, c.total_price AS total_price, c.total_quantity AS total_quantity, " +
                        "c.currency_id AS currency_id, cd.cart_id AS cd_cart_id, cd.quantity AS quantity, " +
                        "i.product_id AS product_id, i.id AS item_id, i.price AS price, i.currency_id AS item_currency_id, " +
                        "i.discount AS discount, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, i.image_source AS item_image_source, p.image_source AS product_image_source," +
                        "b.name AS brand_name " +
                        "FROM cart c " +
                        "LEFT JOIN cart_detail cd ON c.id = cd.cart_id " +
                        "LEFT JOIN item i ON cd.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE 1 = 1 "),
        PARAM_USER_ID(
                "AND c.user_id = ? "),
        PARAM_CART_DATE(
                "AND c.cart_date BETWEEN ? AND ? "),
        PARAM_LOW_TOTAL_PRICE(
                "AND c.total_price >= ? "),
        PARAM_HIGH_TOTAL_PRICE(
                "AND c.total_price <= ? ");

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

    Cart getCartByUserId(int userId);

    List<Cart> getCartByParam(Map<String, Object> param);


}
