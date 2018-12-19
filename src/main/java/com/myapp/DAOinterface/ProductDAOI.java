package com.myapp.DAOinterface;

import com.myapp.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAOI {
    enum SQL {
        UPDATE_PRODUCT_BY_ID("UPDATE product SET name=:name, brand_id=:brand_id, image_source=:image_source," +
                "description:=description WHERE id=:id"),
        GET_ALL_PRODUCTS("SELECT * FROM product"),
        GET_PRODUCT_BY_ID("SELECT * FROM product WHERE id = ?"),
        GET_PRODUCT_BY_NAME("SELECT * FROM product WHERE name = ?"),
        GET_PRODUCT_BY_CATEGORY_ID("SELECT * FROM product p " +
                "JOIN category_product cp ON p.id = cp.product_id" +
                "WHERE cp.category_id = ?"),
        DELETE_PRODUCT_BY_ID("DELETE FROM product WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    Product saveProduct(Product product);

    boolean deleteProductById(int id);

    Product getProductById(int id);

    List<Product> getProductByName(String name);


    List<Product> getProductByCategoryId(int catId);

    List<Product> getProductsByParam(Map<String, String> param);

    List<Product> getAllProducts();
}
