package com.myapp.DAOinterface;

import com.myapp.model.Currency;

import java.util.List;

public interface CurrencyDAOI {
    enum SQL {
        UPDATE_CURRENCY_BY_ID("UPDATE currency SET name=:name, description:=description WHERE id=:id"),
        GET_CURRENCY_BY_ID("SELECT * FROM currency WHERE id = ?"),
        GET_CURRENCY_BY_NAME("SELECT * FROM currency WHERE name = ?"),
        GET_ALL_CURRENCYS("SELECT * FROM currency"),
        DELETE_CURRENCY_BY_ID("DELETE FROM currency WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public Currency saveCurrency(Currency currency);

    public Currency getCurrencyById(int id);

    public boolean deleteCurrencyById(int id);

    Currency getCurrencyByName(String name);

    public List<Currency> getAllCurrencys();
}
