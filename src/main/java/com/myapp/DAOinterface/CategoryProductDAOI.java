package com.myapp.DAOinterface;

public interface CategoryProductDAOI {
    enum SQL {
        DELETE_CATEGORY_PRODUCT_BY_ID("DELETE FROM category_product WHERE category_id = ? AND product_id = ?"),
        DELETE_CATEGORY_PRODUCT_BY_PRODUCT_ID("DELETE FROM category_product WHERE product_id = ?"),
        DELETE_CATEGORY_PRODUCT_BY_CATEGORY_ID("DELETE FROM category_product WHERE category_id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }
}
