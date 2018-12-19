package com.myapp.DAO;

import com.myapp.DAOinterface.ProductDAOI;
import com.myapp.model.Product;
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
public class ProductDAO extends BaseDAO implements ProductDAOI {
    private static final BeanPropertyRowMapper<Product> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertProduct;

    @Autowired
    public ProductDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertProduct = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Product saveProduct(Product product) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", product.getId())
                .addValue("name", product.getName())
                .addValue("brand_id", product.getBrand().getId())
                .addValue("image_source", product.getImageSource())
                .addValue("description", product.getDescription())
                ;

        if (product.isNew()) {
            Number newKey = insertProduct.executeAndReturnKey(map);
            product.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_PRODUCT_BY_ID.getQuery(), map);
        }
        return product;
    }

    @Override
    public boolean deleteProductById(int id) {
        return jdbcTemplate.update(SQL.DELETE_PRODUCT_BY_ID.getQuery(), id) != 0;
    }

    @Override
    public Product getProductById(int id) {
        List<Product> products = jdbcTemplate.query(SQL.GET_PRODUCT_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(products);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return jdbcTemplate.query(SQL.GET_PRODUCT_BY_NAME.getQuery(), ROW_MAPPER, name);
    }

    @Override
    public List<Product> getProductsByParam(Map<String, String> param) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query(SQL.GET_ALL_PRODUCTS.getQuery(), ROW_MAPPER);
    }
}
