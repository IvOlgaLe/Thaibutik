package com.myapp.service;

import com.myapp.DAO.ProductDAO;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public Product saveProduct(Product product) {
        return productDAO.saveProduct(product);
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getProductByName(String name) {
        return productDAO.getProductByName(name);
    }

    public boolean deleteProductById(int id) {
        return productDAO.deleteProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }


}
