package com.myapp.DAOinterface;

import com.myapp.model.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDAOI {
    enum SQL {
        UPDATE_ORDER_BY_ID("UPDATE orders SET user_id=:user_id, order_date=:order_date, total_price=:total_price, currency_id:=currency_id" +
                "delivery_date=:delivery_date, delivery_info=:delivery_info, order_state_id=:order_state_id WHERE id=:id"),
        GET_ORDER_BY_ID("SELECT * FROM orders WHERE id = ?"),
        GET_ORDER_BY_USER_ID("SELECT * FROM orders WHERE user_id = ?"),
        GET_ORDER_BY_OSTATE_ID("SELECT * FROM orders WHERE order_state_id = ?"),
        GET_ORDER_BY_DATE("SELECT * FROM orders WHERE order_date BETWEEN ? AND ?"),
        GET_ORDER_BY_DELIVERY_DATE("SELECT * FROM orders WHERE delivery_date BETWEEN ? AND ?"),
        GET_ALL_ORDERS("SELECT * FROM orders"),
        DELETE_ORDER_BY_ID("DELETE FROM orders WHERE id = ?");

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

    List<Order> getOrderByUserId(int UserId);

    List<Order> getOrderByOStateId(int oStateId);

    List<Order> getOrderByDate(Date fDate, Date sDate);

    List<Order> getOrderByDeliveryDate(Date fDate, Date sDate);


    List<Order> getOrdersByParam(Map<String, String> param);


}
