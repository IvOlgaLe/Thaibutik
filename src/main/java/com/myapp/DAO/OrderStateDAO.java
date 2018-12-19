package com.myapp.DAO;

import com.myapp.DAOinterface.OrderStateDAOI;
import com.myapp.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderStateDAO implements OrderStateDAOI {
    private static final BeanPropertyRowMapper<OrderState> ROW_MAPPER = BeanPropertyRowMapper.newInstance(OrderState.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrderState;

    @Autowired
    public OrderStateDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrderState = new SimpleJdbcInsert(dataSource)
                .withTableName("order_state")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public OrderState saveOrderState(OrderState order_state) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", order_state.getId())
                .addValue("name", order_state.getName());

        if (order_state.isNew()) {
            Number newKey = insertOrderState.executeAndReturnKey(map);
            order_state.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_OSTATE_BY_ID.getQuery(), map);
        }
        return order_state;
    }

    @Override
    public List<OrderState> getAllOrderStates() {
        return jdbcTemplate.query(SQL.GET_ALL_OSTATES.getQuery(), ROW_MAPPER);
    }

    @Override
    public OrderState getOrderStateById(int id) {
        List<OrderState> order_states = jdbcTemplate.query(SQL.GET_OSTATE_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(order_states);
    }

    @Override
    public OrderState getOrderStateByName(String name) {
        List<OrderState> order_states = jdbcTemplate.query(SQL.GET_OSTATE_BY_NAME.getQuery(), ROW_MAPPER, name);
        return DataAccessUtils.singleResult(order_states);
    }

    @Override
    public boolean deleteOrderStateById(int id) {
        return jdbcTemplate.update(SQL.DELETE_OSTATE_BY_ID.getQuery(), id) != 0;
    }
}
