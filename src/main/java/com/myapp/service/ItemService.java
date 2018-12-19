package com.myapp.service;

import com.myapp.DAO.ItemDAO;
import com.myapp.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;

    public Item saveItem(Item item) {
        return itemDAO.saveItem(item);
    }

    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    public boolean deleteItemById(int id) {
        return itemDAO.deleteItemById(id);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }


}
