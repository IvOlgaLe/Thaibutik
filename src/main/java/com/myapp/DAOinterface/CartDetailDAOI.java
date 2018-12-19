package com.myapp.DAOinterface;

import com.myapp.model.CartDetail;

import java.util.List;
import java.util.Map;

public interface CartDetailDAOI {
    enum SQL {
        UPDATE_CDETAIL_BY_ID("UPDATE cart_detail SET cart_id=:cart_id, item_id=:item_id, " +
                "quantity=:quantity WHERE id=:id"),
        GET_ALL_CDETAILS("SELECT * FROM cart_detail"),
        GET_CDETAIL_BY_ID("SELECT * FROM cart_detail WHERE id = ?"),
        GET_CDETAIL_BY_CART_ID("SELECT * FROM cart_detail WHERE cart_id = ?"),
        GET_CDETAIL_BY_ITEM_ID("SELECT * FROM cart_detail WHERE item_id = ?"),
        DELETE_CDETAIL_BY_ID("DELETE FROM cart_detail WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    CartDetail saveCartDetail(CartDetail cart_detail);

    boolean deleteCartDetailById(int id);

    CartDetail getCartDetailById(int id);

    List<CartDetail> getCartDetailByCartId(int CartId);

    List<CartDetail> getCartDetailByItemId(int itemId);

    List<CartDetail> getCartDetailsByParam(Map<String, String> param);

    List<CartDetail> getAllCartDetails();
}
