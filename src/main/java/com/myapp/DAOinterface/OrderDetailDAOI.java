package com.myapp.DAOinterface;

import com.myapp.model.OrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailDAOI {
    enum SQL {
        UPDATE_ODETAIL_BY_ID("UPDATE order_detail SET order_id=:order_id, item_id=:item_id, price=:price, currency_id=:currency_id, " +
                "quantity=:quantity WHERE order_id=:order_id AND item_id=:item_id"),
        DELETE_ODETAIL_BY_ORDER_ID("DELETE FROM order_detail WHERE order_id = ?"),
        DELETE_ODETAIL_BY_ID("DELETE FROM order_detail WHERE order_id = ? AND item_id = ?"),
        GET_ODETAIL_BY_ID(
                "SELECT od.order_id AS order_id, od.item_id AS item_id, od.currency_id AS currency_id, " +
                        "i.product_id AS product_id, p.name AS product_name, b.name AS brand_name, " +
                        "od.quantity AS quantity, od.price AS price, od.currency_id AS currency_id, " +
                        "i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.image_source AS product_image_source, i.image_source AS item_image_source " +
                        "FROM order_detail od " +
                        "JOIN item i ON od.item_id = i.id " +
                        "JOIN product p ON i.product_id = p.id " +
                        "JOIN brand b ON p.brand_id = b.id " +
                        "WHERE od.order_id = ? AND od.item_id = ? "),
        GET_ODETAIL_BY_PARAM(
                "SELECT od.order_id AS order_id, od.item_id AS item_id, od.currency_id AS currency_id, " +
                        "i.product_id AS product_id, p.name AS product_name, b.name AS brand_name, " +
                        "od.quantity AS quantity, od.price AS price, od.currency_id AS currency_id, " +
                        "i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.image_source AS product_image_source, i.image_source AS item_image_source  " +
                        "FROM order_detail od " +
                        "JOIN item i ON od.item_id = i.id " +
                        "JOIN product p ON i.product_id = p.id " +
                        "JOIN brand b ON p.brand_id = b.id " +
                        "WHERE 1 = 1 "),
        PARAM_ORDER_ID(
                "AND od.order_id = ? "),
        PARAM_ITEM_ID(
                "AND  od.item_id = ? ");


        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    OrderDetail saveOrderDetail(OrderDetail order_detail);

    boolean deleteOrderDetailByOrderId(int orderId);

    boolean deleteOrderDetailById(int orderId, int itemId);

    OrderDetail getOrderDetailById(int orderId, int itemId);

    List<OrderDetail> getOrderDetailsByParam(Map<String, Object> param);

    List<OrderDetail> getAllOrderDetails();
}
