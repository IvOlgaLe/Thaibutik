package com.myapp.DAOinterface;

public interface OrderDAOI {
    enum SQL {
        INSERT_ORDER("INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)"),       //7 items
        UPDATE_ORDER_BY_ID("UPDATE users SET name=:name, email=:email, password=:password, role_id=:roleId, " +
                "address=:address, phone=:phone, birthday=:birthday WHERE user_id=:userId"),
        GET_ORDER_BY_ID("SELECT * FROM orders WHERE order_id = ?"),
        GET_ORDERBY_USERID("SELECT * FROM orders WHERE user_id = ?"),
        GET_ALL_ORDERS("SELECT * FROM orders"),
        DELETE_ORDER_BY_ID("DELETE FROM order WHERE order_id = ?")
        ;

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }
}
