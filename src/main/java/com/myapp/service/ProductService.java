package com.myapp.service;

import com.myapp.DAO.*;
import com.myapp.exception.NotAvailableItemException;
import com.myapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    GroupDAO groupDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    OrderService orderService;

    @Autowired
    CategoryProductDAO categoryProductDAO;

    public Map<String, Object> createParamMap(HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>();
        if (request.getParameter("categoryId") != null && !request.getParameter("categoryId").isEmpty())
            param.put("categoryId", request.getParameter("categoryId"));
        if (request.getParameter("name") != null && !request.getParameter("name").isEmpty())
            param.put("name", request.getParameter("name"));
        if (request.getParameter("brandId") != null && !request.getParameter("brandId").isEmpty())
            param.put("brandId", request.getParameter("brandId"));
        if (request.getParameter("itemType") != null && !request.getParameter("itemType").isEmpty())
            param.put("itemType", request.getParameter("itemType"));
        if (request.getParameter("itemSize") != null && !request.getParameter("itemSize").isEmpty())
            param.put("itemSize", request.getParameter("itemSize"));
        if (request.getParameter("lowPrice") != null && !request.getParameter("lowPrice").isEmpty())
            param.put("lowPrice", request.getParameter("lowPrice"));
        if (request.getParameter("highPrice") != null && !request.getParameter("highPrice").isEmpty())
            param.put("highPrice", request.getParameter("highPrice"));
        if (request.getParameter("orderBy") != null && !request.getParameter("orderBy").isEmpty())
            param.put("orderBy", request.getParameter("orderBy"));
        return param;
    }

    //-----Product------
    public Product saveProduct(Product product) {
        Product result = productDAO.saveProduct(product);
        if (result != null && product.getItemList() != null) {
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

    /**
     * Method deletes a product and its items if there is no orders with those items.
     *
     * @param id
     * @return
     */
    public boolean deleteProductById(int id) {
        List<Item> itemList = getItemByProductId(id);
        if (itemList != null && !itemList.isEmpty()) {
            Map<String, Object> param = new HashMap<>();
            for (Item item : itemList) {
                param.put("itemId", item.getId());
                List<OrderDetail> orderDetailList = orderService.getOrderDetailsByParam(param);
                if (orderDetailList != null && !orderDetailList.isEmpty()) {
                    return false;
                }
            }
            return itemDAO.deleteItemByProductId(id) && productDAO.deleteProductById(id);
        } else return productDAO.deleteProductById(id);
    }

    public List<Product> getAllProducts() {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "p.id, i.price*(1-i.discount/100)");
        return productDAO.getProductByParam(param);
    }

    public List<Product> getAllProducts(Map<String, Object> param) {
        if(!param.containsKey("orderBy"))
            param.put("orderBy", "p.id, i.price*(1-i.discount/100)");
        return productDAO.getProductByParam(param);
    }

    public List<Product> getProductByCategoryId(int categoryId) {
        return productDAO.getProductByCategoryId(categoryId);
    }

    public List<Product> getProductByParam(Map<String, Object> param) {
        if(!param.containsKey("orderBy"))
            param.put("orderBy", "p.id, i.price*(1-i.discount/100)");
        return productDAO.getProductByParam(param);
    }

    //----Item---
    public Item saveItem(Item item) {
        return itemDAO.saveItem(item);
    }

    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    public List<Item> getItemByProductId(int productId) {
        return itemDAO.getItemByProductId(productId);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public boolean deleteItemById(int id) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemId", id);
        List<OrderDetail> orderDetailList = orderService.getOrderDetailsByParam(param);
        if (orderDetailList != null && !orderDetailList.isEmpty()) {
            return false;
        }
        return itemDAO.deleteItemById(id);
    }

    public boolean deleteItemByProductId(int productId) {
        return deleteProductById(productId);
    }

    public Item getItemUpdatedQuantity(int itemId, int quantity, List<Exception> exceptionList) {
        Item item = getItemById(itemId);
        if (item.getAvailable()) {
            if (item.getQuantity() >= quantity) {
                int newQuantity = item.getQuantity() - quantity;
                item.setQuantity(newQuantity);
                item.setQuantOrdered(item.getQuantOrdered() + quantity);
                //if item is sold out set "is not available"
                if(newQuantity < 1) {
                    item.setAvailable(false);
                }
                return item;
            } else {
                exceptionList.add(new NotAvailableItemException("Unfortunately, there are " + item.getQuantity() + " items in stock"));
                return null;
            }
        } else {
            exceptionList.add(new NotAvailableItemException("Unfortunately, this product is not available"));
            return null;
        }
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

    public boolean saveCategoryProduct(int categoryId, int productId) {
        return categoryProductDAO.saveCategoryProduct(categoryId, productId);
    }

    public boolean deleteCategoryProductById(int categoryId, int productId) {
        return categoryProductDAO.deleteCategoryProductById(categoryId, productId);
    }

    public boolean deleteCategoryProductByProductId(int productId) {
        return categoryProductDAO.deleteCategoryProductByProductId(productId);
    }

    //---Group-----
    public Group saveGroup(Group group) {
        return groupDAO.saveGroup(group);
    }

    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    public Group getGroupById(int id) {
        return groupDAO.getGroupById(id);
    }

    public List<Group> getGroupByName(String name) {
        return groupDAO.getGroupByName(name);
    }

    public boolean deleteGroupById(int id) {
        return groupDAO.deleteGroupById(id);
    }

    //----Brand-----
    public Brand saveBrand(Brand brand) {
        return brandDAO.saveBrand(brand);
    }

    public List<Brand> getAllBrands() {
        return brandDAO.getAllBrands();
    }

    public Brand getBrandById(int id) {
        return brandDAO.getBrandById(id);
    }

    public List<Brand> getBrandByName(String name) {
        return brandDAO.getBrandByName(name);
    }

    public boolean deleteBrandById(int id) {
        return brandDAO.deleteBrandById(id);
    }
}
