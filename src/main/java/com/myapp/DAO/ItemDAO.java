package com.myapp.DAO;

import com.myapp.DAOinterface.ItemDAOI;
import com.myapp.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDAO extends BaseDAO implements ItemDAOI {
    private static final BeanPropertyRowMapper<Item> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Item.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertItem;

    @Autowired
    public ItemDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertItem = new SimpleJdbcInsert(dataSource)
                .withTableName("item")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Item saveItem(Item item) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", item.getId())
                .addValue("product_id", item.getProductId())
                .addValue("price", item.getPrice())
                .addValue("item_type", item.getItemType())
                .addValue("item_size", item.getItemSize())
                .addValue("currency_id", item.getCurrencyId())
                .addValue("quantity", item.getQuantity())
                .addValue("quantity", item.getQuantity())
                .addValue("quant_ordered", item.getQuantOrdered())
                .addValue("image_source", item.getImageSource())
                .addValue("discount", item.getDiscount())
                .addValue("available", item.getAvailable());

        if (item.isNew()) {
            Number newKey = insertItem.executeAndReturnKey(map);
            item.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(ItemDAOI.SQL.UPDATE_ITEM_BY_ID.getQuery(), map);
        }
        return item;
    }

    @Override
    public boolean deleteItemById(int id) {
        return jdbcTemplate.update(SQL.DELETE_ITEM_BY_ID.getQuery(), id) != 0;
    }

    @Override
    public boolean deleteItemByProductId(int productId) {
        return jdbcTemplate.update(SQL.DELETE_ITEM_BY_PRODUCT_ID.getQuery(), productId) != 0;
    }

    @Override
    public Item getItemById(int id) {
        List<Item> items = jdbcTemplate.query(SQL.GET_ITEM_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(items);
    }

    @Override
    public List<Item> getItemByProductId(int ProductId) {
        return jdbcTemplate.query(SQL.GET_ITEM_BY_PRODUCT_ID.getQuery(), ROW_MAPPER, ProductId);
    }

    @Override
    public List<Item> getItemByPrice(BigDecimal lPrice, BigDecimal hPrice) {
        return jdbcTemplate.query(SQL.GET_ITEM_BY_PRICE.getQuery(), ROW_MAPPER, lPrice, hPrice);
    }

    @Override
    public List<Item> getItemsByParam(Map<String, String> param) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL.GET_ALL_ITEMS.getQuery(), ROW_MAPPER);
    }
}
