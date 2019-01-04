package com.myapp.DAO;

import com.myapp.DAOinterface.CartDetailDAOI;
import com.myapp.model.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CartDetailDAO extends BaseDAO implements CartDetailDAOI {

    private static final BeanPropertyRowMapper<CartDetail> ROW_MAPPER = BeanPropertyRowMapper.newInstance(CartDetail.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCartDetail;

    @Autowired
    public CartDetailDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCartDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("cart_detail");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public CartDetail saveCartDetail(CartDetail cartDetail) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("cart_id", cartDetail.getCartId())
                .addValue("item_id", cartDetail.getItemId())
                .addValue("quantity", cartDetail.getQuantity());

        if (getCartDetailById(cartDetail.getCartId(), cartDetail.getItemId()) == null) {
            insertCartDetail.execute(map);
        } else {
            namedParameterJdbcTemplate.update(CartDetailDAOI.SQL.UPDATE_CDETAIL_BY_ID.getQuery(), map);
        }
        return cartDetail;
    }

    @Override
    public boolean deleteCartDetailById(int cartId, int itemId) {
        return jdbcTemplate.update(SQL.DELETE_CDETAIL_BY_ID.getQuery(), cartId, itemId) != 0;
    }

    @Override
    public boolean deleteCartDetailByCartId(int cartId) {
        return jdbcTemplate.update(SQL.DELETE_CDETAIL_BY_CART_ID.getQuery(), cartId) != 0;
    }

    @Override
    public boolean deleteCartDetailByItemId(int itemId) {
        return jdbcTemplate.update(SQL.DELETE_CDETAIL_BY_ITEM_ID.getQuery(), itemId) != 0;
    }

    @Override
    public CartDetail getCartDetailById(int cartId, int itemId) {
        List<CartDetail> cartDetails = jdbcTemplate.query(SQL.GET_CDETAIL_BY_ID.getQuery(), ROW_MAPPER, cartId, itemId);
        return DataAccessUtils.singleResult(cartDetails);
    }

    @Override
    public List<CartDetail> getAllCartDetails() {
        return jdbcTemplate.query(SQL.GET_CDETAIL_BY_PARAM.getQuery(), ROW_MAPPER);
    }

    @Override
    public List<CartDetail> getCartDetailsByParam(Map<String, String> param) {
        String query = SQL.GET_CDETAIL_BY_PARAM.getQuery();
        List<Object> argsList = new ArrayList<>();
        if (param.get("cartId") != null) {
            query = query + SQL.PARAM_CART_ID.getQuery();
            argsList.add(param.get("cartId"));
        }
        if (param.get("itemId") != null) {
            query = query + SQL.PARAM_ITEM_ID.getQuery();
            argsList.add(param.get("itemId"));
        }
        if (param.get("orderBy") != null) {
            query = query + "ORDER BY " + param.get("orderBy");
        }
        Object[] args = argsList.toArray();
        return jdbcTemplate.query(query, ROW_MAPPER, args);
    }
}
