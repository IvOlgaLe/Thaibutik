package com.myapp.DAO;

import com.myapp.DAOinterface.BrandDAOI;
import com.myapp.model.Brand;
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
public class BrandDAO implements BrandDAOI {
    private static final BeanPropertyRowMapper<Brand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Brand.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertBrand;

    @Autowired
    public BrandDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertBrand = new SimpleJdbcInsert(dataSource)
                .withTableName("brand")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", brand.getId())
                .addValue("name", brand.getName())
                .addValue("description", brand.getDescription())
                ;

        if (brand.isNew()) {
            Number newKey = insertBrand.executeAndReturnKey(map);
            brand.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_BRAND_BY_ID.getQuery(), map);
        }
        return brand;
    }

    @Override
    public List<Brand> getAllBrands() {
        return jdbcTemplate.query(SQL.GET_ALL_BRANDS.getQuery(), ROW_MAPPER);
    }

    @Override
    public Brand getBrandById(int id) {
        List<Brand> brands = jdbcTemplate.query(SQL.GET_BRAND_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(brands);
    }

    @Override
    public Brand getBrandByName(String name) {
        List<Brand> brands = jdbcTemplate.query(SQL.GET_BRAND_BY_NAME.getQuery(), ROW_MAPPER, name);
        return DataAccessUtils.singleResult(brands);
    }

    @Override
    public boolean deleteBrandById(int id) {
        return jdbcTemplate.update(SQL.DELETE_BRAND_BY_ID.getQuery(), id) != 0;
    }
}
