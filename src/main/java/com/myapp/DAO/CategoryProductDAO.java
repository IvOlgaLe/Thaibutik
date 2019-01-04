package com.myapp.DAO;

import com.myapp.DAOinterface.CategoryProductDAOI;
import com.myapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CategoryProductDAO implements CategoryProductDAOI {
    private static final BeanPropertyRowMapper<Category> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Category.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCategory;

    @Autowired
    public CategoryProductDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCategory = new SimpleJdbcInsert(dataSource)
                .withTableName("category_product");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public boolean saveCategoryProduct(int categoryId, int productId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("categoryId", categoryId)
                .addValue("productId", productId)
                ;
        return insertCategory.execute(map) != 0;
    }

    public boolean deleteCategoryProductById(int categoryId, int productId) {
        return jdbcTemplate.update(SQL.DELETE_CATEGORY_PRODUCT_BY_ID.getQuery(), categoryId, productId) != 0;
    }

    public boolean deleteCategoryProductByProductId(int productId) {
        return jdbcTemplate.update(SQL.DELETE_CATEGORY_PRODUCT_BY_PRODUCT_ID.getQuery(), productId) != 0;
    }

    public boolean deleteCategoryProductByCategoryId(int categoryId) {
        return jdbcTemplate.update(SQL.DELETE_CATEGORY_PRODUCT_BY_CATEGORY_ID.getQuery(), categoryId) != 0;
    }
}
