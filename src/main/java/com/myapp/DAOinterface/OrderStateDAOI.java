package com.myapp.DAOinterface;

import com.myapp.model.OrderState;

import java.util.List;

public interface OrderStateDAOI {
    enum SQL {
        UPDATE_OSTATE_BY_ID("UPDATE order_state SET name=:name WHERE id=:id"),
        GET_OSTATE_BY_ID("SELECT * FROM order_state WHERE id = ?"),
        GET_OSTATE_BY_NAME("SELECT * FROM order_state WHERE name = ?"),
        GET_ALL_OSTATES("SELECT * FROM order_state"),
        DELETE_OSTATE_BY_ID("DELETE FROM order_state WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public OrderState saveOrderState(OrderState order_state);

    public OrderState getOrderStateById(int id);

    public boolean deleteOrderStateById(int id);

    OrderState getOrderStateByName(String name);

    public List<OrderState> getAllOrderStates();
}
