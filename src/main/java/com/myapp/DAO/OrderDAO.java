package com.myapp.DAO;

import com.myapp.DAOinterface.OrderDAOI;
import com.myapp.model.Order;
import com.myapp.model.OrderDetail;
import com.myapp.model.OrderState;
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
public class OrderDAO extends BaseDAO implements OrderDAOI {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrder;

    @Autowired
    public OrderDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrder = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private class MyObjectExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Order> map = new HashMap<Integer, Order>();
            List<Order> resultList = new ArrayList<Order>();
            while (rs.next()) {
                Integer order_id = rs.getInt("order_id");
                Order order = map.get(order_id);
                if (order == null) {
                    order = new Order();
                }
                if(!resultList.contains(order)) {
                    resultList.add(order);
                }

                order.setId(order_id);
                order.setUserId(rs.getInt("user_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setTotalPrice(rs.getBigDecimal("total_price"));
                order.setTotalQuantity(rs.getInt("total_quantity"));
                order.setCurrencyId(rs.getInt("currency_id"));
                order.setDeliveryDate(rs.getDate("delivery_date"));
                order.setDeliveryInfo(rs.getString("delivery_info"));
                order.setDeliveryAddress(rs.getString("delivery_address"));

                OrderState orderState = new OrderState();
                orderState.setId(rs.getInt("order_state_id"));
                orderState.setName(rs.getString("order_state_name"));

                order.setOrderState(orderState);
                map.put(order_id, order);

                List<OrderDetail> orderDetailList = order.getOrderDetailList();
                if (orderDetailList == null) {
                    orderDetailList = new ArrayList<OrderDetail>();
                }
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(rs.getInt("order_id"));
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setItemId(rs.getInt("item_id"));
                orderDetail.setProductName(rs.getString("product_name"));
                orderDetail.setBrandName(rs.getString("brand_name"));
                orderDetail.setItemType(rs.getString("item_type"));
                orderDetail.setItemSize(rs.getString("item_size"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setPrice(rs.getBigDecimal("price"));
                orderDetail.setCurrencyId(rs.getInt("item_currency_id"));
                orderDetail.setProductImageSource(rs.getString("product_image_source"));
                orderDetail.setItemImageSource(rs.getString("item_image_source"));
                orderDetailList.add(orderDetail);
                order.setOrderDetailList(orderDetailList);
            }
            return resultList;
        }
    }

    private final MyObjectExtractor MY_OBJECT_EXTRACTOR = new MyObjectExtractor();

    @Override
    public Order saveOrder(Order order) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("user_id", order.getUserId())
                .addValue("order_date", order.getOrderDate())
                .addValue("total_price", order.getTotalPrice())
                .addValue("total_quantity", order.getTotalQuantity())
                .addValue("delivery_date", order.getDeliveryDate())
                .addValue("delivery_address", order.getDeliveryAddress())
                .addValue("delivery_info", order.getDeliveryInfo())
                .addValue("currency_id", order.getCurrencyId())
                .addValue("order_state_id", order.getOrderState().getId());

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
        return (List<Order>) jdbcTemplate.query(SQL.GET_ORDER_BY_PARAM.getQuery(), MY_OBJECT_EXTRACTOR);
    }

    @Override
    public Order getOrderById(int id) {
        List<Order> orders = (List<Order>) jdbcTemplate.query(SQL.GET_ORDER_BY_ID.getQuery(), MY_OBJECT_EXTRACTOR, id);
        return DataAccessUtils.singleResult(orders);
    }

    @Override
    public List<Order> getOrderByParam(Map<String, Object> param) {
        String query = SQL.GET_ORDER_BY_PARAM.getQuery();
        List<Object> argsList = new ArrayList<>();
        if (param.get("userId") != null) {
            query = query + SQL.PARAM_USER_ID.getQuery();
            argsList.add(param.get("userId"));
        }
        if (param.get("orderStateId") != null) {
            query = query + SQL.PARAM_OSTATE_ID.getQuery();
            argsList.add(param.get("orderStateId"));
        }
        if (param.get("beginOrderDate") != null) {
            query = query + SQL.PARAM_ORDER_DATE.getQuery();
            argsList.add(param.get("beginOrderDate"));
            argsList.add(param.get("endOrderDate"));
        }
        if (param.get("beginDeliveryDate") != null) {
            query = query + SQL.PARAM_DELIVERY_DATE.getQuery();
            argsList.add(param.get("beginDeliveryDate"));
            argsList.add(param.get("endDeliveryDate"));
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
        }
        Object[] args = argsList.toArray();
        return (List<Order>) jdbcTemplate.query(query, MY_OBJECT_EXTRACTOR, args);
    }
}
