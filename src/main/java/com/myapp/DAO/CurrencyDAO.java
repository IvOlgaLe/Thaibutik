package com.myapp.DAO;

import com.myapp.DAOinterface.CurrencyDAOI;
import com.myapp.model.Currency;
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
public class CurrencyDAO implements CurrencyDAOI {
    private static final BeanPropertyRowMapper<Currency> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Currency.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertCurrency;

    @Autowired
    public CurrencyDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertCurrency = new SimpleJdbcInsert(dataSource)
                .withTableName("currency")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Currency saveCurrency(Currency currency) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", currency.getId())
                .addValue("name", currency.getName())
                .addValue("description", currency.getDescription())
                ;

        if (currency.isNew()) {
            Number newKey = insertCurrency.executeAndReturnKey(map);
            currency.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_CURRENCY_BY_ID.getQuery(), map);
        }
        return currency;
    }

    @Override
    public List<Currency> getAllCurrencys() {
        return jdbcTemplate.query(SQL.GET_ALL_CURRENCYS.getQuery(), ROW_MAPPER);
    }

    @Override
    public Currency getCurrencyById(int id) {
        List<Currency> currencies = jdbcTemplate.query(SQL.GET_CURRENCY_BY_ID.getQuery(), ROW_MAPPER, id);
        return DataAccessUtils.singleResult(currencies);
    }

    @Override
    public Currency getCurrencyByName(String name) {
        List<Currency> currencies = jdbcTemplate.query(SQL.GET_CURRENCY_BY_NAME.getQuery(), ROW_MAPPER, name);
        return DataAccessUtils.singleResult(currencies);
    }

    @Override
    public boolean deleteCurrencyById(int id) {
        return jdbcTemplate.update(SQL.DELETE_CURRENCY_BY_ID.getQuery(), id) != 0;
    }
}
