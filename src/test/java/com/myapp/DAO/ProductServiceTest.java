package com.myapp.DAO;

import com.myapp.model.*;
import com.myapp.model.Product;
import com.myapp.service.ProductService;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.Boolean.TRUE;

public class ProductServiceTest extends BaseTestClass {

    @Autowired
    private ProductService productService;

    //------ProductDAO----------
    @Test
    public void testCRUDProduct() {
        //-----save------
        Brand brand = new Brand(201, "Mary Key", "Mary Key Description");
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(0, new BigDecimal("12.09"), "Item Type", "Item Size", 11, 20, 5, "img02", 15.0, TRUE));
        Product productExp = new Product("Cream Save", brand, "img01", "description to product Cream", itemList);
        Product product = productService.saveProduct(productExp);
        int productId = product.getId();

        //-----getById-------
        Product productAct = productService.getProductById(productId);
        Assert.assertEquals(productExp, productAct);

        //-----update-----
        productExp.setName("Cream Update");
        productService.saveProduct(productExp);

        //-----getAll-----
        List<Product> productList = productService.getAllProducts();
        for (Product u: productList) {
            if(u.getId() == productId) {
                productAct = u;
                break;
            }
        }
        Assert.assertEquals(productExp, productAct);

        //-----delete-----
        boolean deleteResult = productService.deleteProductById(productId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(productService.getProductById(productId));
    }

    @Test
    public  void testGetProductByName() {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "SoA");
        List<Product> productList = productService.getProductByParam(param);
        Assert.assertEquals("Soap", productList.get(0).getName());
    }

    @Test
    public void testGetProductByBrandId() {
        Map<String, Object> param = new HashMap<>();
        param.put("brandId", 202);
        List<Product> productList = productService.getProductByParam(param);
        Assert.assertEquals("Soap", productList.get(0).getName());
    }

    @Test
    public void testGetProductByPrice() {
        Map<String, Object> param = new HashMap<>();
        param.put("lowPrice", new BigDecimal(5));
        param.put("highPrice", new BigDecimal(40));
        List<Product> productList = productService.getProductByParam(param);
        Assert.assertEquals(2, productList.get(0).getItemList().size());
    }

    @Test
    public void testGetProductByCategoryId() {
        Map<String, Object> param = new HashMap<>();
        param.put("categoryId", 101);
        List<Product> productList = productService.getProductByParam(param);
        Assert.assertEquals(1, productList.size());
    }

    @Test
    public void testGetProductByItemTypeSize() {
        Map<String, Object> param = new HashMap<>();
        param.put("itemType", "strawberry");
        param.put("itemSize", "50 ml");
        List<Product> productList = productService.getProductByParam(param);
        Assert.assertEquals(1, productList.size());
    }

    @Test
    public void testGetAllProductOrderBy() {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "name");
        List<Product> productList = productService.getAllProducts(param);
        Assert.assertEquals(2, productList.size());
        Assert.assertEquals("Shampoo", productList.get(0).getName());
    }

    //-----CategoryDAO-----------
    @Test
    public void testCRUDCategory() {
        //-----save------
        Category categoryExp = new Category("Moisturizer", "Description");
        Category category = productService.saveCategory(categoryExp);
        int categoryId = category.getId();

        //-----getById-------
        Category categoryAct = productService.getCategoryById(categoryId);
        Assert.assertEquals(categoryExp, categoryAct);

        //-----update-----
        categoryExp.setName("Creams");
        productService.saveCategory(categoryExp);

        //-----getAll-----
        List<Category> categoryList = productService.getAllCategories();
        for (Category c: categoryList) {
            if(c.getId() == categoryId) {
                categoryAct = c;
                break;
            }
        }
        Assert.assertEquals(categoryExp, categoryAct);

        //-----delete-----
        boolean deleteResult = productService.deleteCategoryById(categoryId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(productService.getCategoryById(categoryId));
    }

    @Test
    public void testGetCategoryByProductId() {
        //category_product (product_id, category_id) VALUES (100001, 101);
        List<Category> categoryList = productService.getCategoryByProductId(100001);
        Assert.assertEquals("Bestsellers", categoryList.get(0).getName());
    }

    @Test
    public void testGetCategoryByName() {
        //category (name, description) VALUES ('Bath', 'Bath Description');
        List<Category> categoryList = productService.getCategoryByName("Bath");
        Assert.assertEquals("Bath", categoryList.get(0).getName());
    }

    //-----GroupDAO-----------
    @Test
    public void testCRUDGroup() {
        //-----save------
        Group groupExp = new Group("Hair", "Description", null);
        Group group = productService.saveGroup(groupExp);
        int groupId = group.getId();

        //-----getById-------
        Group groupAct = productService.getGroupById(groupId);
        Assert.assertEquals(groupExp, groupAct);

        //-----update-----
        groupExp.setName("Skincare");
        productService.saveGroup(groupExp);

        //-----getAll-----
        List<Group> groupList = productService.getAllGroups();
        for (Group c: groupList) {
            if(c.getId() == groupId) {
                groupAct = c;
                break;
            }
        }
        Assert.assertEquals(groupExp, groupAct);

        //-----delete-----
        boolean deleteResult = productService.deleteGroupById(groupId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(productService.getGroupById(groupId));
    }

    @Test
    public void testGetGroupByName() {
        //group (name, description) VALUES ('Bath', 'Bath Description');
        List<Group> groupList = productService.getGroupByName("Bath");
        Assert.assertEquals("Bath/Body", groupList.get(0).getName());
    }

    //-----ItemDAO-----
    @Test
    public void testCRUDItem() {
        //-----save------
        Item itemExp = new Item(100002, new BigDecimal("16.35"), "Blueberry", "50 ml", 11, 25, 14, "img02", 15.0, TRUE);
        Item item = productService.saveItem(itemExp);
        int itemId = item.getId();

        //-----getById-------
        Item itemAct = productService.getItemById(itemId);
        Assert.assertEquals(itemExp, itemAct);

        //-----update-----
        itemExp.setQuantity(55);
        productService.saveItem(itemExp);

        //-----getAll-----
        List<Item> itemList = productService.getAllItems();
        for (Item c: itemList) {
            if(c.getId() == itemId) {
                itemAct = c;
                break;
            }
        }
        Assert.assertEquals(itemExp, itemAct);

        //-----delete-----
        boolean deleteResult = productService.deleteItemById(itemId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(productService.getItemById(itemId));
    }
}
