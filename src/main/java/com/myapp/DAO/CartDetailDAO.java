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

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

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
                .addValue("cart_id", cartDetail.getCart().getId())
                .addValue("item_id", cartDetail.getItem().getId())
                .addValue("quantity", cartDetail.getQuantity())
                ;

        if (getCartDetailById(cartDetail.getCart().getId(), cartDetail.getItem().getId()) == null) {
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
    public CartDetail getCartDetailById(int cartId, int itemId) {
        List<CartDetail> cartDetails = jdbcTemplate.query(SQL.GET_CDETAIL_BY_ID.getQuery(), ROW_MAPPER, cartId, itemId);
        return DataAccessUtils.singleResult(cartDetails);
    }

    @Override
    public List<CartDetail> getCartDetailByCartId(int cartId) {
        return jdbcTemplate.query(SQL.GET_CDETAIL_BY_CART_ID.getQuery(), ROW_MAPPER, cartId);
    }
    @Override
    public List<CartDetail> getCartDetailByItemId(int itemId) {
        return jdbcTemplate.query(SQL.GET_CDETAIL_BY_ITEM_ID.getQuery(), ROW_MAPPER, itemId);
    }

    @Override
    public List<CartDetail> getCartDetailsByParam(Map<String, String> param) {
        return null;
    }

    @Override
    public List<CartDetail> getAllCartDetails() {
        return jdbcTemplate.query(SQL.GET_ALL_CDETAILS.getQuery(), ROW_MAPPER);
    }

}
