package com.myapp.DAOinterface;

import com.myapp.model.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ItemDAOI {
    enum SQL {
        UPDATE_ITEM_BY_ID("UPDATE item SET product_id=:product_id, price=:price, item_type=:item_type, item_size=:item_size, " +
                "currency_id=:currency_id, quantity=:quantity, quant_ordered=:quant_ordered, image_source=:image_source," +
                "discount=:discount, available=:available WHERE id=:id"),
        GET_ALL_ITEMS("SELECT * FROM item"),
        GET_ITEM_BY_ID("SELECT * FROM item WHERE id = ?"),
        GET_ITEM_BY_PRICE("SELECT * FROM item WHERE price BETWEEN ? AND ?"),
        GET_ITEM_BY_PRODUCT_ID("SELECT * FROM item i JOIN product p ON i.product_id = p.id WHERE p.id = ?"),
        DELETE_ITEM_BY_ID("DELETE FROM item WHERE id = ?"),
        DELETE_ITEM_BY_PRODUCT_ID("DELETE FROM item WHERE product_id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    Item saveItem(Item item);

    boolean deleteItemById(int id);

    boolean deleteItemByProductId(int productId);

    Item getItemById(int id);

    List<Item> getItemByProductId(int ProductId);

    List<Item> getItemByPrice(BigDecimal lPrice, BigDecimal hPrice);

    List<Item> getItemsByParam(Map<String, String> param);

    List<Item> getAllItems();
}
