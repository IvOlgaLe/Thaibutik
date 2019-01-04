package com.myapp.DAO;

import com.myapp.DAOinterface.CartDAOI;
import com.myapp.model.Cart;
import com.myapp.model.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CartDAO extends BaseDAO implements CartDAOI {

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

    private class MyObjectExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Cart> map = new HashMap<Integer, Cart>();
            List<Cart> resultList = new ArrayList<Cart>();
            while (rs.next()) {
                Integer cart_id = rs.getInt("cart_id");
                Cart cart = map.get(cart_id);
                if (cart == null) {
                    cart = new Cart();
                }
                if (!resultList.contains(cart)) {
                    resultList.add(cart);
                }

                cart.setId(cart_id);
                cart.setUserId(rs.getInt("user_id"));
                cart.setCartDate(rs.getDate("cart_date"));
                cart.setTotalPrice(rs.getBigDecimal("total_price"));
                cart.setTotalQuantity(rs.getInt("total_quantity"));
                cart.setCurrencyId(rs.getInt("currency_id"));

                map.put(cart_id, cart);

                int itemId = rs.getInt("item_id");
                if (itemId != 0) {
                    List<CartDetail> cartDetailList = cart.getCartDetailList() != null ? cart.getCartDetailList() : new ArrayList<>();
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCartId(rs.getInt("cd_cart_id"));
                    cartDetail.setProductId(rs.getInt("product_id"));
                    cartDetail.setItemId(itemId);
                    cartDetail.setProductName(rs.getString("product_name"));
                    cartDetail.setBrandName(rs.getString("brand_name"));
                    cartDetail.setItemType(rs.getString("item_type"));
                    cartDetail.setItemSize(rs.getString("item_size"));
                    cartDetail.setQuantity(rs.getInt("quantity"));
                    cartDetail.setDiscount(rs.getInt("discount"));
                    cartDetail.setPrice(rs.getBigDecimal("price"));
                    cartDetail.setCurrencyId(rs.getInt("item_currency_id"));
                    cartDetail.setProductImageSource(rs.getString("product_image_source"));
                    cartDetail.setItemImageSource(rs.getString("item_image_source"));
                    cartDetailList.add(cartDetail);
                    cart.setCartDetailList(cartDetailList);
                }
            }
            return resultList;
        }
    }

    private final MyObjectExtractor MY_OBJECT_EXTRACTOR = new MyObjectExtractor();

    @Override
    public Cart saveCart(Cart cart) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", cart.getId())
                .addValue("user_id", cart.getUserId())
                .addValue("cart_date", cart.getCartDate())
                .addValue("total_price", cart.getTotalPrice())
                .addValue("total_quantity", cart.getTotalQuantity())
                .addValue("currency_id", cart.getCurrencyId());

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
        return (List<Cart>) jdbcTemplate.query(SQL.GET_CART_BY_PARAM.getQuery(), MY_OBJECT_EXTRACTOR);
    }

    @Override
    public Cart getCartById(int id) {
        List<Cart> carts = (List<Cart>) jdbcTemplate.query(SQL.GET_CART_BY_ID.getQuery(), MY_OBJECT_EXTRACTOR, id);
        return DataAccessUtils.singleResult(carts);
    }

    @Override
    public Cart getCartByUserId(int userId) {
        String query = SQL.GET_CART_BY_PARAM.getQuery() + SQL.PARAM_USER_ID.getQuery();
        List<Cart> carts = (List<Cart>) jdbcTemplate.query(query, MY_OBJECT_EXTRACTOR, userId);
        return DataAccessUtils.singleResult(carts);
    }

    @Override
    public List<Cart> getCartByParam(Map<String, Object> param) {
        String query = SQL.GET_CART_BY_PARAM.getQuery();
        List<Object> argsList = new ArrayList<>();
        if (param.get("userId") != null) {
            query = query + SQL.PARAM_USER_ID.getQuery();
            argsList.add(param.get("userId"));
        }
        if (param.get("beginCartDate") != null) {
            query = query + SQL.PARAM_CART_DATE.getQuery();
            argsList.add(param.get("beginCartDate"));
            argsList.add(param.get("endCartDate"));
        }
        if (param.get("lowTotalPrice") != null) {
            query = query + SQL.PARAM_LOW_TOTAL_PRICE.getQuery();
            argsList.add(param.get("lowTotalPrice"));
        }
        if (param.get("highTotalPrice") != null) {
            query = query + SQL.PARAM_HIGH_TOTAL_PRICE.getQuery();
            argsList.add(param.get("highTotalPrice"));
        }
        if (param.get("orderBy") != null) {
            query = query + "ORDER BY " + param.get("orderBy");
        } else if (param.get("orderByDesc") != null) {
            query = query + "ORDER BY " + param.get("orderByDesc") + " DESC";
        }
        Object[] args = argsList.toArray();
        return (List<Cart>) jdbcTemplate.query(query, MY_OBJECT_EXTRACTOR, args);
    }


}
