package com.myapp.DAO;

import com.myapp.DAOinterface.CategoryDAOI;
import com.myapp.model.Category;
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
public class CategoryDAO implements CategoryDAOI {
    private static final BeanPropertyRowMapper<Category> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Category.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCategory;

    @Autowired
    public CategoryDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCategory = new SimpleJdbcInsert(dataSource)
                .withTableName("category")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Category saveCategory(Category category) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", category.getId())
                .addValue("name", category.getName())
                .addValue("description", category.getDescription())
                ;

        if (category.isNew()) {
            Number newKey = insertCategory.executeAndReturnKey(map);
            category.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_CATEGORY_BY_ID.getQuery(), map);
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL.GET_ALL_CATEGORIES.getQuery(), ROW_MAPPER);
    }

    @Override
    public Category getCategoryById(int id) {
        List<Category> categories = jdbcTemplate.query(SQL.GET_CATEGORY_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(categories);
    }

    @Override
    public List<Category> getCategoryByProductId(int product_id) {
        return jdbcTemplate.query(SQL.GET_CATEGORY_BY_PRODUCT_ID.getQuery(), ROW_MAPPER, product_id);
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        return  jdbcTemplate.query(SQL.GET_CATEGORY_BY_NAME.getQuery(), ROW_MAPPER, "%" + name + "%");
    }

    @Override
    public boolean deleteCategoryById(int id) {
        return jdbcTemplate.update(SQL.DELETE_CATEGORY_BY_ID.getQuery(), id) != 0;
    }
}
