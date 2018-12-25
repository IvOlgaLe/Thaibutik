package com.myapp.service;

import com.myapp.DAO.BrandDAO;
import com.myapp.DAO.CategoryDAO;
import com.myapp.DAO.ItemDAO;
import com.myapp.DAO.ProductDAO;
import com.myapp.model.Category;
import com.myapp.model.Item;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    BrandDAO brandDAO;

    @Autowired
    CategoryDAO categoryDAO;

    //-----Product------
    public Product saveProduct(Product product) {
        Product result = productDAO.saveProduct(product);
        if (result != null) {
            List<Item> itemList = product.getItemList();
            for (Item item : itemList) {
                item.setProductId(result.getId());
                saveItem(item);
            }
        }
        return result;
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public boolean deleteProductById(int id) {
        return deleteItemByProductId(id) && productDAO.deleteProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getProductByParam(new HashMap<>());
    }

    public List<Product> getAllProducts(Map<String, Object> param) {
        return productDAO.getProductByParam(param);
    }

    public List<Product> getProductByParam(Map<String, Object> param) {
        return productDAO.getProductByParam(param);
    }

    //----Item---
    public Item saveItem(Item item) {
        return itemDAO.saveItem(item);
    }

    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public boolean deleteItemById(int id) {
        return itemDAO.deleteItemById(id);
    }

    public boolean deleteItemByProductId(int productId) {
        return deleteProductById(productId);
    }

    //---Category-----
    public Category saveCategory(Category category) {
        return categoryDAO.saveCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    public List<Category> getCategoryByProductId(int product_id) {
        return categoryDAO.getCategoryByProductId(product_id);
    }

    public List<Category> getCategoryByName(String name) {
        return categoryDAO.getCategoryByName(name);
    }

    public boolean deleteCategoryById(int id) {
        return categoryDAO.deleteCategoryById(id);
    }
}
