package com.myapp.DAO;

import com.myapp.DAOinterface.OrderDAOI;
import com.myapp.DAOinterface.OrderDetailDAOI;
import com.myapp.model.Order;
import com.myapp.model.OrderDetail;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDetailDAO extends BaseDAO implements OrderDetailDAOI {
    private static final BeanPropertyRowMapper<OrderDetail> ROW_MAPPER = BeanPropertyRowMapper.newInstance(OrderDetail.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrderDetail;

    @Autowired
    public OrderDetailDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrderDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("order_detail");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("order_id", orderDetail.getOrderId())
                .addValue("item_id", orderDetail.getItemId())
                .addValue("price", orderDetail.getPrice())
                .addValue("quantity", orderDetail.getQuantity())
                .addValue("currency_id", orderDetail.getCurrencyId())
                .addValue("discount", orderDetail.getDiscount());

        if (getOrderDetailById(orderDetail.getOrderId(), orderDetail.getItemId()) == null) {
            insertOrderDetail.execute(map);
        } else {
            namedParameterJdbcTemplate.update(OrderDetailDAOI.SQL.UPDATE_ODETAIL_BY_ID.getQuery(), map);
        }
        return orderDetail;
    }

    @Override
    public boolean deleteOrderDetailByOrderId(int orderId) {
        return jdbcTemplate.update(SQL.DELETE_ODETAIL_BY_ORDER_ID.getQuery(), orderId) != 0;
    }

    @Override
    public boolean deleteOrderDetailById(int orderId, int itemId) {
        return jdbcTemplate.update(OrderDetailDAOI.SQL.DELETE_ODETAIL_BY_ID.getQuery(), orderId, itemId) != 0;
    }

    @Override
    public OrderDetail getOrderDetailById(int orderId, int itemId) {
        List<OrderDetail> oDetails = jdbcTemplate.query(OrderDetailDAOI.SQL.GET_ODETAIL_BY_ID.getQuery(), ROW_MAPPER, orderId, itemId);
        return DataAccessUtils.singleResult(oDetails);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return jdbcTemplate.query(SQL.GET_ODETAIL_BY_PARAM.getQuery(), ROW_MAPPER);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByParam(Map<String, String> param) {
        String query = SQL.GET_ODETAIL_BY_PARAM.getQuery();
        List<Object> argsList = new ArrayList<>();
        if (param.get("orderId") != null) {
            query = query + SQL.PARAM_ORDER_ID.getQuery();
            argsList.add(param.get("orderId"));
        }
        if (param.get("itemId") != null) {
            query = query + SQL.PARAM_ITEM_ID.getQuery();
            argsList.add(param.get("itemId"));
        }
        if (param.get("orderBy") != null) {
            query = query + "ORDER BY " + param.get("orderBy");
        } else if (param.get("orderByDesc") != null) {
            query = query + "ORDER BY " + param.get("orderByDesc") + " DESC";
        }
        Object[] args = argsList.toArray();
        return jdbcTemplate.query(query, ROW_MAPPER, args);
    }

}
