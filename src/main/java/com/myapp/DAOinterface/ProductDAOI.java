package com.myapp.DAOinterface;

import com.myapp.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductDAOI {

    enum SQL {
        UPDATE_PRODUCT_BY_ID(
                "UPDATE product SET name=:name, brand_id=:brand_id, image_source=:image_source," +
                        "description=:description WHERE id=:id"),
      /*  GET_ALL_PRODUCTS(
                "SELECT p.id AS product_id, p.name AS name, p.brand_id AS brand_id, p.image_source AS image_source, p.description AS description, " +
                        "b.name AS brand_name, b.description AS brand_description, " +
                        "i.id AS item_id, i.price AS price, i.item_type AS item_type, i.item_size AS item_size, i.currency_id AS currency_id, i.quantity AS quantity, " +
                        "i.quant_ordered AS quant_ordered, i.image_source AS item_image_source, i.discount AS discount, i.available AS available " +
                        "FROM product p " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "LEFT JOIN item i ON p.id = i.product_id " +
                        "ORDER BY p.id, i.price*(1-i.discount/100) " +
                        "FETCH FIRST 50 ROWS ONLY"),*/
        DELETE_PRODUCT_BY_ID("DELETE FROM product WHERE id = ?"),
        GET_PRODUCT_BY_IDs(
                "SELECT p.id AS product_id, p.name AS name, p.brand_id AS brand_id, p.image_source AS image_source, p.description AS description, " +
                        "b.name AS brand_name, b.description AS brand_description, " +
                        "i.id AS item_id, i.price AS price, i.item_type AS item_type, i.item_size AS item_size, i.currency_id AS currency_id, i.quantity AS quantity, " +
                        "i.quant_ordered AS quant_ordered, i.image_source AS item_image_source, i.discount AS discount, i.available AS available " +
                        "FROM product p " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "LEFT JOIN item i ON p.id = i.product_id " +
                        "WHERE p.id IN (?)"),
        GET_PRODUCT_BY_ID(
                "SELECT p.id AS product_id, p.name AS name, p.brand_id AS brand_id, p.image_source AS image_source, p.description AS description, " +
                        "b.name AS brand_name, b.description AS brand_description, " +
                        "i.id AS item_id, i.price AS price, i.item_type AS item_type, i.item_size AS item_size, i.currency_id AS currency_id, i.quantity AS quantity, " +
                        "i.quant_ordered AS quant_ordered, i.image_source AS item_image_source, i.discount AS discount, i.available AS available " +
                        "FROM product p " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "LEFT JOIN item i ON p.id = i.product_id " +
                        "WHERE p.id = ? " +
                        "ORDER BY p.id, i.price*(1-i.discount/100)"),
        GET_PRODUCT_BY_CAT_PARAM(
                "SELECT p.id AS product_id, p.name AS name, p.brand_id AS brand_id, p.image_source AS image_source, p.description AS description, " +
                        "b.name AS brand_name, b.description AS brand_description, " +
                        "cp.category_id AS category_id, c.name AS category_name, " +
                        "i.id AS item_id, i.price AS price, i.item_type AS item_type, i.item_size AS item_size, i.currency_id AS currency_id, i.quantity AS quantity, " +
                        "i.quant_ordered AS quant_ordered, i.image_source AS item_image_source, i.discount AS discount, i.available AS available " +
                        "FROM product p " +
                        "JOIN category_product cp ON p.id = cp.product_id " +
                        "JOIN category c ON cp.category_id = c.id " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "LEFT JOIN item i ON p.id = i.product_id " +
                        "WHERE c.id = ? "),
        GET_PRODUCT_BY_PARAM(
                "SELECT p.id AS product_id, p.name AS name, p.brand_id AS brand_id, p.image_source AS image_source, p.description AS description, " +
                        "b.name AS brand_name, b.description AS brand_description, " +
                        "i.id AS item_id, i.price AS price, i.item_type AS item_type, i.item_size AS item_size, i.currency_id AS currency_id, i.quantity AS quantity, " +
                        "i.quant_ordered AS quant_ordered, i.image_source AS item_image_source, i.discount AS discount, i.available AS available " +
                        "FROM product p " +
                        "LEFT JOIN brand b ON p.brand_id = b.id " +
                        "LEFT JOIN item i ON p.id = i.product_id " +
                        "WHERE 1 = 1 "),
        PARAM_NAME(
                "AND UPPER(p.name) LIKE ? "),
        PARAM_BRAND_ID(
                "AND p.brand_id = ? "),
        PARAM_ITEM_TYPE(
                "AND UPPER(i.item_type) LIKE ? "),
        PARAM_ITEM_SIZE(
                "AND UPPER(i.item_size) LIKE ? "),
        PARAM_LOW_PRICE(
                "AND i.price >= ? "),
        PARAM_HIGH_PRICE(
                "AND i.price <= ? ");


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

    List<Product> getProductByCategoryId(int categoryId);

    List<Product> getProductByParam(Map<String, Object> param);

}
