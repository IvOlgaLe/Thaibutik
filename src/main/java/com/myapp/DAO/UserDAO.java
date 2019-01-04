package com.myapp.DAO;

import com.myapp.DAOinterface.UserDAOI;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAO extends BaseDAO implements UserDAOI {

    private static final BeanPropertyRowMapper<User> ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertUser;

    @Autowired
    public UserDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertUser = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("role_id", user.getRoleId())
                .addValue("address", user.getAddress())
                .addValue("phone", user.getPhone())
                .addValue("birthday", user.getBirthday());

        if (user.isNew()) {
            Number newKey = insertUser.executeAndReturnKey(map);
            user.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_USER_BY_ID.getQuery(), map);
        }
        return user;
    }

    @Override
    public boolean deleteUserById(int id) {
        return jdbcTemplate.update(SQL.DELETE_USER_BY_ID.getQuery(), id) != 0;
    }

    @Override
    public User getUserById(int id) {
        List<User> users = jdbcTemplate.query(SQL.GET_USER_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> users = jdbcTemplate.query(SQL.GET_USER_BY_EMAIL.getQuery(), ROW_MAPPER, email);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getUsersByParam(Map<String, Object> param) {
        String query = SQL.GET_USER_BY_PARAM.getQuery();
        List<Object> argsList = new ArrayList<>();
        if (param.get("name") != null) {
            query = query + SQL.PARAM_NAME.getQuery();
            argsList.add("%" + param.get("name").toString().toUpperCase() + "%");
        }
        if (param.get("address") != null) {
            query = query + SQL.PARAM_ADDRESS.getQuery();
            argsList.add("%" + param.get("address").toString().toUpperCase() + "%");
        }
        if (param.get("role_id") != null) {
            query = query + SQL.PARAM_ROLE_ID.getQuery();
            argsList.add(param.get("role_id"));
        }
        if (param.get("phone") != null) {
            query = query + SQL.PARAM_PHONE.getQuery();
            argsList.add(param.get("phone"));               //add validation and save with +1 or +7
        }
        if (param.get("birthday") != null) {
            query = query + SQL.PARAM_BIRTHDAY.getQuery();
            argsList.add(param.get("birthday"));
        }
        if (param.get("orderBy") != null) {
            query = query + "ORDER BY " + param.get("orderBy");
        }
        Object[] args = argsList.toArray();
        return jdbcTemplate.query(query, ROW_MAPPER, args);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL.GET_USER_BY_PARAM.getQuery(), ROW_MAPPER);
    }

    public User validateUser(String email, String inputPassword) {
        User user = getUserByEmail(email);
        return user != null ? user.getPassword().equals(inputPassword) ? user : null : null;
    }
}
