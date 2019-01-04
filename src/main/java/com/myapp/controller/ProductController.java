package com.myapp.controller;

import com.myapp.enums.Constants;
import com.myapp.model.Category;
import com.myapp.model.Item;
import com.myapp.model.Product;
import com.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    public ModelAndView catalog() {
        return new ModelAndView("catalog");
    }

    @RequestMapping(value = "product/{productId}/{itemId}", method = RequestMethod.GET)
    public ModelAndView productPage(
            @PathVariable("productId") int productId,
            @PathVariable("itemId") int itemId,
            HttpServletRequest request) {
        Product product = productService.getProductById(productId);
        Item item;
        if (request.getParameter("categoryId") != null) {
            int categoryId = Integer.valueOf(request.getParameter("categoryId"));
            Category category = productService.getCategoryById(categoryId);
            request.setAttribute("category", category);
        }
        if (itemId != 0) {
            item = productService.getItemById(itemId);
        } else item = !product.getItemList().isEmpty() ? product.getItemList().get(0) : null;
        request.setAttribute("product", product);
        request.setAttribute("item", item);
        return new ModelAndView("product");
    }

    @RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
    public ModelAndView productListPage(
            @PathVariable("categoryId") int categoryId, HttpServletRequest request) {
        List<Product> productList;
        if (request.getParameter("applyFilter") != null) {
            Map<String, Object> param = productService.createParamMap(request);
            productList = productService.getProductByParam(param);
        } else {
            productList = productService.getProductByCategoryId(categoryId);
        }
        Category category = productService.getCategoryById(categoryId);
        request.setAttribute("productList", productList);
        request.setAttribute("category", category);
        return new ModelAndView("product_list");
    }

    @RequestMapping(value = "processSearch", method = RequestMethod.GET)
    public ModelAndView searchResultPage(Model model, HttpServletRequest request) {
        model.addAttribute("searchWord", request.getParameter("name"));
        List<Product> productList;
        Map<String, Object> param = productService.createParamMap(request);
        productList = productService.getProductByParam(param);
        request.setAttribute("productList", productList);
        return new ModelAndView("search_result");
    }

    @RequestMapping(value = "productTable", method = RequestMethod.GET)
    public ModelAndView productTablePage(HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "p.id");
        request.setAttribute("productList", productService.getAllProducts());
        return new ModelAndView("product_table");
    }

    @RequestMapping(value = "editProduct/{productId}", method = RequestMethod.GET)
    public ModelAndView editProductPage(
            @PathVariable("productId") int productId,
            HttpServletRequest request) {
        request.setAttribute("product", productService.getProductById(productId));
        return new ModelAndView("product_edit");
    }

    @RequestMapping(value = "processEditProduct", method = RequestMethod.GET)
    public String processEditProduct(
            @ModelAttribute("editedProduct") Product editedProduct,
            HttpServletRequest request) {
        if(request.getParameter("brandId") != null && !request.getParameter("brandId").isEmpty() ) {
            editedProduct.setBrand(productService.getBrandById(Integer.valueOf(request.getParameter("brandId"))));
        } else {
            editedProduct.setBrand(productService.getBrandByName(Constants.NO_BRAND).get(0));
        }
        productService.saveProduct(editedProduct);
        if(request.getParameter("categoryId") != null) {
            productService.saveCategoryProduct(Integer.valueOf(request.getParameter("categoryId")), editedProduct.getId());
        }
        return "redirect:/productTable";
    }

    @RequestMapping(value = "processDeleteProduct/{productId}", method = RequestMethod.GET)
    public String processDeleteProduct(
            @PathVariable("productId") int productId,
            RedirectAttributes redir) {
        if (!productService.deleteProductById(productId)) {
            redir.addFlashAttribute("errorDeleteMsg", "Failed to delete product " + productId + " (product is in an order)");
        }
        return "redirect:/productTable";
    }

    @RequestMapping(value = "itemsTable/{productId}", method = RequestMethod.GET)
    public ModelAndView itemsTablePage(
            @PathVariable("productId") int productId,
            HttpServletRequest request) {
        request.setAttribute("product", productService.getProductById(productId));
        return new ModelAndView("items_table");
    }

    @RequestMapping(value = "editItem/{productId}/{itemId}", method = RequestMethod.GET)
    public ModelAndView editItemPage(
            @PathVariable("productId") int productId,
            @PathVariable("itemId") int itemId,
            HttpServletRequest request) {
        request.setAttribute("product", productService.getProductById(productId));
        request.setAttribute("item", productService.getItemById(itemId));
        return new ModelAndView("item_edit");
    }

    @RequestMapping(value = "processEditItem", method = RequestMethod.GET)
    public String processEditItem(
            @ModelAttribute("editedItem") Item editedItem) {
        productService.saveItem(editedItem);
        int productId = editedItem.getProductId();
        return "redirect:/itemsTable/" + productId;
    }

    @RequestMapping(value = "processDeleteItem/{productId}/{itemId}", method = RequestMethod.GET)
    public String processDeleteItem(
            @PathVariable("productId") int productId,
            @PathVariable("itemId") int itemId,
            RedirectAttributes redir) {
        if (!productService.deleteItemById(itemId)) {
            redir.addFlashAttribute("errorDeleteMsg", "Failed to delete item " + itemId + " (item is in an order)");
        }
        return "redirect:/itemsTable/" + productId;
    }

}
