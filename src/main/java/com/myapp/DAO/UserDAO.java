package com.myapp.DAO;

import com.myapp.DAOinterface.UserDAOI;
import com.myapp.model.User;
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
import java.util.Map;

@Repository
public class UserDAO extends BaseDAO implements UserDAOI {

    private static final BeanPropertyRowMapper<User> ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    private final JdbcTemplate jdbcTemplate;

/*    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

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
                .addValue("role_id", user.getRole().getId())
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
    public List<User> getUsersByParam(Map<String, String> param) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL.GET_ALL_USERS.getQuery(), ROW_MAPPER);
    }

    public User validateUser(String email, String inputPassword) {
        User user = getUserByEmail(email);
        return user != null ? user.getPassword().equals(inputPassword) ? user : null : null;
    }
}
