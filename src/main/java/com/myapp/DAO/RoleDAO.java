package com.myapp.DAO;

import com.myapp.DAOinterface.RoleDAOI;
import com.myapp.model.Role;
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
public class RoleDAO implements RoleDAOI {
    private static final BeanPropertyRowMapper<Role> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Role.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertRole;

    @Autowired
    public RoleDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertRole = new SimpleJdbcInsert(dataSource)
                .withTableName("role")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Role saveRole(Role role) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", role.getId())
                .addValue("name", role.getName());

        if (role.isNew()) {
            Number newKey = insertRole.executeAndReturnKey(map);
            role.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_ROLE_BY_ID.getQuery(), map);
        }
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return jdbcTemplate.query(SQL.GET_ALL_ROLES.getQuery(), ROW_MAPPER);
    }

    @Override
    public Role getRoleById(int id) {
        List<Role> roles = jdbcTemplate.query(SQL.GET_ROLE_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(roles);
    }

    @Override
    public Role getRoleByName(String name) {
        List<Role> roles = jdbcTemplate.query(SQL.GET_ROLE_BY_NAME.getQuery(), ROW_MAPPER, name);
        return DataAccessUtils.singleResult(roles);
    }

    @Override
    public boolean deleteRoleById(int id) {
        return jdbcTemplate.update(SQL.DELETE_ROLE_BY_ID.getQuery(), id) != 0;
    }
}
