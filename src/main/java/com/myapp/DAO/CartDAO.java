package com.myapp.DAO;

import com.myapp.DAOinterface.CartDAOI;
import com.myapp.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class CartDAO extends BaseDAO implements CartDAOI {
    private static final BeanPropertyRowMapper<Cart> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Cart.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCart;

    @Autowired
    public CartDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCart = new SimpleJdbcInsert(dataSource)
                .withTableName("cart")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Cart saveCart(Cart cart) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", cart.getId())
                .addValue("user_id", cart.getUserId())
                .addValue("cart_date", cart.getCartDate())
                .addValue("total_price", cart.getTotalPrice())
                .addValue("currency_id", cart.getCurrency().getCurrencyCode())
                ;

        if (cart.isNew()) {
            Number newKey = insertCart.executeAndReturnKey(map);
            cart.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_CART_BY_ID.getQuery(), map);
        }
        return cart;
    }

    @Override
    public boolean deleteCartById(int id) {
        return jdbcTemplate.update(SQL.DELETE_CART_BY_ID.getQuery(), id) != 0;
    }
    @Override
    public List<Cart> getAllCarts() {
        return jdbcTemplate.query(SQL.GET_ALL_CARTS.getQuery(), ROW_MAPPER);
    }
    @Override
    public Cart getCartById(int id) {
        List<Cart> carts = jdbcTemplate.query(SQL.GET_CART_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(carts);
    }

    @Override
    public List<Cart> getCartByUserId(int userId) {
        return jdbcTemplate.query(SQL.GET_CART_BY_USER_ID.getQuery(), ROW_MAPPER, userId);
    }


    @Override
    public List<Cart> getCartByDate(Date fDate, Date sDate) {
        return jdbcTemplate.query(SQL.GET_CART_BY_DATE.getQuery(), ROW_MAPPER, fDate, sDate);
    }

    @Override
    public List<Cart> getCartsByParam(Map<String, String> param) {
        return null;
    }


}
