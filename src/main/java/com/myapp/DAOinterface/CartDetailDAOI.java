package com.myapp.DAOinterface;

import com.myapp.model.CartDetail;

import java.util.List;
import java.util.Map;

public interface CartDetailDAOI {
    enum SQL {
        UPDATE_CDETAIL_BY_ID("UPDATE cart_detail SET cart_id=:cart_id, item_id=:item_id, " +
                "quantity=:quantity WHERE cart_id=:cart_id AND item_id=:item_id"),
        DELETE_CDETAIL_BY_ID("DELETE FROM cart_detail WHERE cart_id = ? AND item_id = ?"),
        DELETE_CDETAIL_BY_CART_ID("DELETE FROM cart_detail WHERE cart_id = ?"),
        DELETE_CDETAIL_BY_ITEM_ID("DELETE FROM cart_detail WHERE item_id = ?"),
        GET_CDETAIL_BY_ID(
                "SELECT cd.cart_id AS cart_id, cd.quantity AS quantity, " +
                        "i.product_id AS product_id, i.id AS item_id, i.price AS price, i.currency_id AS currency_id, " +
                        "i.discount AS discount, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, i.image_source AS item_image_source, p.image_source AS product_image_source, i.image_source AS item_image_source, " +
                        "b.name AS brand_name " +
                        "FROM cart_detail cd " +
                        "LEFT JOIN item i ON cd.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE cd.cart_id = ? AND cd.item_id = ?"),
        GET_CDETAIL_BY_PARAM(
                "SELECT cd.cart_id AS cart_id, cd.quantity AS quantity, " +
                        "i.product_id AS product_id, i.id AS item_id, i.price AS price, i.currency_id AS currency_id, " +
                        "i.discount AS discount, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, i.image_source AS item_image_source, p.image_source AS product_image_source, i.image_source AS item_image_source, " +
                        "b.name AS brand_name " +
                        "FROM cart_detail cd " +
                        "LEFT JOIN item i ON cd.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE 1 = 1"),
        PARAM_CART_ID(
                "AND cd.cart_id = ? "),
        PARAM_ITEM_ID(
                "AND cd.item_id = ? ");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    CartDetail saveCartDetail(CartDetail cart_detail);

    boolean deleteCartDetailById(int cartId, int itemId);

    boolean deleteCartDetailByCartId(int cartId);

    boolean deleteCartDetailByItemId(int itemId);

    CartDetail getCartDetailById(int cartId, int itemId);

    List<CartDetail> getCartDetailsByParam(Map<String, String> param);

    List<CartDetail> getAllCartDetails();
}
