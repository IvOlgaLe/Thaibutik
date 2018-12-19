package com.myapp.service;

import com.myapp.DAO.CurrencyDAO;
import com.myapp.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyDAO currencyDAO;

    public Currency saveCurrency(Currency currency) {
        return currencyDAO.saveCurrency(currency);
    }

    public Currency getCurrencyById(int id) {
        return currencyDAO.getCurrencyById(id);
    }

    public boolean deleteCurrencyById(int id) {
        return currencyDAO.deleteCurrencyById(id);
    }

    public List<Currency> getAllCurrencys() {
        return currencyDAO.getAllCurrencys();
    }


}
