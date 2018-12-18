package com.myapp.DAOinterface;

public interface ProductDAOI {
    enum SQL {
        INSERT_PRODUCT("INSERT INTO product VALUES (?, ?, ?, ?, ?)"),       //5 items
        UPDATE_PRODUCT_BY_ID("UPDATE users SET name=:name, email=:email, password=:password, role_id=:roleId, " +
                "address=:address, phone=:phone, birthday=:birthday WHERE user_id=:userId"),
        GET_PRODUCT_BY_ID("SELECT * FROM users WHERE user_id = ?"),
        GET_PRODUCT_BY_BRANDID("SELECT * FROM product WHERE brand_id = ?"),
        GET_ALL_PRODUCTS("SELECT * FROM product"),
        DELETE_PRODUCT_BY_ID("DELETE FROM product WHERE product_id = ?")
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
