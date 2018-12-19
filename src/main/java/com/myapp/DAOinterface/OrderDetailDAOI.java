package com.myapp.DAOinterface;

import com.myapp.model.OrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailDAOI {
    enum SQL {
        UPDATE_ODETAIL_BY_ID("UPDATE order_detail SET order_id:=order_id, item_id=:item_id, price=:price, currency_id=:currency_id, " +
                "quantity=:quantity, discount=:discount WHERE order_id=:order_id AND item_id:=item_id"),
        GET_ALL_ODETAILS("SELECT * FROM order_detail"),
        GET_ODETAIL_BY_ORDER_ID("SELECT * FROM order_detail WHERE order_id = ?"),
        GET_ODETAIL_BY_ITEM_ID("SELECT * FROM order_detail WHERE item_id = ?"),
        DELETE_ODETAIL_BY_ORDERID("DELETE FROM order_detail WHERE order_id = ?"),
        DELETE_ODETAIL_BY_ID("DELETE FROM order_detail WHERE order_id = ? AND item_id = ?")
        ;

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    OrderDetail saveOrderDetail(OrderDetail order_detail);

    boolean deleteOrderDetailById(int orderId, int itemId);

    OrderDetail getOrderDetailById(int orderId, int itemId);

    List<OrderDetail> getOrderDetailByOrderId(int orderId);

    List<OrderDetail> getOrderDetailByItemId(int ItemId);

    List<OrderDetail> getOrderDetailsByParam(Map<String, String> param);

    List<OrderDetail> getAllOrderDetails();
}
