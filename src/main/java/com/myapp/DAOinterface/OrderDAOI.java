package com.myapp.DAOinterface;

import com.myapp.model.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDAOI {
    enum SQL {
        UPDATE_ORDER_BY_ID("UPDATE orders SET user_id=:user_id, order_date=:order_date, total_price=:total_price, currency_id=:currency_id, " +
                "delivery_date=:delivery_date, delivery_address=:delivery_address, delivery_info=:delivery_info, order_state_id=:order_state_id WHERE id=:id"),
        GET_ORDER_BY_ID(
                "SELECT o.id AS order_id, o.user_id AS user_id, o.order_date AS order_date, o.total_price AS total_price, o.total_quantity AS total_quantity, " +
                        "o.currency_id AS currency_id, o.delivery_date AS delivery_date, o.delivery_info AS delivery_info, " +
                        "o.delivery_address AS delivery_address, o.order_state_id AS order_state_id, os.name AS order_state_name, " +
                        "od.quantity AS quantity, od.price AS price, od.currency_id AS item_currency_id, " +
                        "i.product_id AS product_id, i.id AS item_id, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, p.image_source AS product_image_source, i.image_source AS item_image_source, " +
                        "b.name AS brand_name " +
                        "FROM orders o " +
                        "JOIN order_state os ON o.order_state_id = os.id " +
                        "LEFT JOIN order_detail od ON o.id = od.order_id " +
                        "LEFT JOIN item i ON od.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE o.id = ?"),
        DELETE_ORDER_BY_ID("DELETE FROM orders WHERE id = ?"),
        GET_ORDER_BY_PARAM(
                "SELECT o.id AS order_id, o.user_id AS user_id, o.order_date AS order_date, o.total_price AS total_price, o.total_quantity AS total_quantity, " +
                        "o.currency_id AS currency_id, o.delivery_date AS delivery_date, o.delivery_info AS delivery_info, " +
                        "o.delivery_address AS delivery_address, o.order_state_id AS order_state_id, os.name AS order_state_name, " +
                        "od.quantity AS quantity, od.price AS price, od.currency_id AS item_currency_id, " +
                        "i.product_id AS product_id, i.id AS item_id, i.item_type AS item_type, i.item_size AS item_size, " +
                        "p.name AS product_name, p.image_source AS product_image_source, i.image_source AS item_image_source, " +
                        "b.name AS brand_name " +
                        "FROM orders o " +
                        "JOIN order_state os ON o.order_state_id = os.id " +
                        "LEFT JOIN order_detail od ON o.id = od.order_id " +
                        "LEFT JOIN item i ON od.item_id = i.id " +
                        "LEFT JOIN product p ON i.product_id = p.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "WHERE 1 = 1 "),
        PARAM_USER_ID(
                "AND o.user_id = ? "),
        PARAM_OSTATE_ID(
                "AND o.order_state_id = ? "),
        PARAM_ORDER_DATE(
                "AND o.order_date BETWEEN ? AND ? "),
        PARAM_DELIVERY_DATE(
                "AND o.delivery_date BETWEEN ? AND ? "),
        PARAM_LOW_TOTAL_PRICE(
                "AND o.total_price >= ? "),
        PARAM_HIGH_TOTAL_PRICE(
                "AND o.total_price <= ? "),
        ;

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    Order saveOrder(Order order);

    boolean deleteOrderById(int id);

    List<Order> getAllOrders();

    Order getOrderById(int id);

    List<Order> getOrderByParam(Map<String, Object> param);


}
