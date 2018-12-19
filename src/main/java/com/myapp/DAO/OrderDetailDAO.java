package com.myapp.DAO;

import com.myapp.DAOinterface.OrderDetailDAOI;
import com.myapp.model.OrderDetail;
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

public class OrderDetailDAO  extends BaseDAO implements OrderDetailDAOI {
    private static final BeanPropertyRowMapper<OrderDetail> ROW_MAPPER = BeanPropertyRowMapper.newInstance(OrderDetail.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrderDetail;

    @Autowired
    public OrderDetailDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrderDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("order_detail")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", orderDetail.getId())
                .addValue("order_id", orderDetail.getOrder().getId())
                .addValue("item_id", orderDetail.getItem().getId())
                .addValue("price", orderDetail.getPrice())
                .addValue("quantity", orderDetail.getQuantity())
                .addValue("currency_id", orderDetail.getCurrency().getId())
                .addValue("discount", orderDetail.getDiscount())
                ;

        if (orderDetail.isNew()) {
            Number newKey = insertOrderDetail.executeAndReturnKey(map);
            orderDetail.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(OrderDetailDAOI.SQL.UPDATE_ODETAIL_BY_ID.getQuery(), map);
        }
        return orderDetail;
    }

    @Override
    public boolean deleteOrderDetailById(int id) {
        return jdbcTemplate.update(OrderDetailDAOI.SQL.DELETE_ODETAIL_BY_ID.getQuery(), id) != 0;
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        List<OrderDetail> orderDetails = jdbcTemplate.query(OrderDetailDAOI.SQL.GET_ODETAIL_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(orderDetails);
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
            return jdbcTemplate.query(OrderDetailDAOI.SQL.GET_ODETAIL_BY_ITEM_ID.getQuery(), ROW_MAPPER, orderId);
    }

    @Override
    public List<OrderDetail> getOrderDetailByItemId(int itemId) {
        return jdbcTemplate.query(OrderDetailDAOI.SQL.GET_ODETAIL_BY_ITEM_ID.getQuery(), ROW_MAPPER, itemId);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByParam(Map<String, String> param) {
        return null;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return jdbcTemplate.query(OrderDetailDAOI.SQL.GET_ALL_ODETAILS.getQuery(), ROW_MAPPER);
    }

}
