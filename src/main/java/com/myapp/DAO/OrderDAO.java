package com.myapp.DAO;

import com.myapp.DAOinterface.OrderDAOI;
import com.myapp.model.Order;
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
public class OrderDAO  extends BaseDAO implements OrderDAOI {
    private static final BeanPropertyRowMapper<Order> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Order.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrder;

    @Autowired
    public OrderDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrder = new SimpleJdbcInsert(dataSource)
                .withTableName("order")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Order saveOrder(Order order) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("user_id", order.getUserId())
                .addValue("order_date", order.getOrderDate())
                .addValue("total_price", order.getTotalPrice())
                .addValue("delivery_date", order.getDeliveryDate())
                .addValue("delivery_info", order.getDeliveryInfo())
                .addValue("currency_id", order.getCurrency().getCurrencyCode())
                .addValue("order_state_id", order.getOrderState().getId())
                ;

        if (order.isNew()) {
            Number newKey = insertOrder.executeAndReturnKey(map);
            order.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(OrderDAOI.SQL.UPDATE_ORDER_BY_ID.getQuery(), map);
        }
        return order;
    }

    @Override
    public boolean deleteOrderById(int id) {
        return jdbcTemplate.update(OrderDAOI.SQL.DELETE_ORDER_BY_ID.getQuery(), id) != 0;
    }
    @Override
    public List<Order> getAllOrders() {
        return jdbcTemplate.query(OrderDAOI.SQL.GET_ALL_ORDERS.getQuery(), ROW_MAPPER);
    }
    @Override
    public Order getOrderById(int id) {
        List<Order> orders = jdbcTemplate.query(OrderDAOI.SQL.GET_ORDER_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(orders);
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return jdbcTemplate.query(OrderDAOI.SQL.GET_ORDER_BY_USER_ID.getQuery(), ROW_MAPPER, userId);
    }

    @Override
    public List<Order> getOrderByOStateId(int oStateId) {
        return jdbcTemplate.query(SQL.GET_ORDER_BY_OSTATE_ID.getQuery(), ROW_MAPPER, oStateId);
    }

    @Override
    public List<Order> getOrderByDate(Date fDate, Date sDate) {
        return jdbcTemplate.query(SQL.GET_ORDER_BY_DATE.getQuery(), ROW_MAPPER, fDate, sDate);
    }

    @Override
    public List<Order> getOrderByDeliveryDate(Date fDate, Date sDate) {
        return jdbcTemplate.query(SQL.GET_ORDER_BY_DELIVERY_DATE.getQuery(), ROW_MAPPER, fDate, sDate);
    }

    @Override
    public List<Order> getOrdersByParam(Map<String, String> param) {
        return null;
    }


}
