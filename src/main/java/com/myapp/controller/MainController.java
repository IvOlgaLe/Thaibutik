package com.myapp.controller;

import com.myapp.enums.Constants;
import com.myapp.model.Product;
import com.myapp.service.CartService;
import com.myapp.service.CurrencyService;
import com.myapp.service.OrderService;
import com.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MainController extends BaseController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("groupList", productService.getAllGroups());
        session.setAttribute("brandList", productService.getAllBrands());
        session.setAttribute("categoryList", productService.getAllCategories());
        session.setAttribute("currencyList", currencyService.getAllCurrencys());
        session.setAttribute("orderStateList", orderService.getAllOrderStates());
        session.setAttribute("bestsellersList", productService.getProductByCategoryId(
                productService.getCategoryByName(Constants.BESTSELLERS).get(0).getId()));
        return "redirect:/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView indexPage(HttpServletRequest request) {
        //show 15 random products
        List<Product> randomProductList = new ArrayList<>();
        List<Product> allProductList = productService.getAllProducts();
        for (int i = 0; i < 15; i++) {
            if (allProductList.size() == 0) {      //if less then 15
                break;
            }
            int number = (int) Math.random() * (allProductList.size() - 1);
            randomProductList.add(allProductList.get(number));
            allProductList.remove(number);
        }
        request.setAttribute("productList", randomProductList);
        return new ModelAndView("index");
    }

    @RequestMapping(value = "aboutUs", method = RequestMethod.GET)
    public ModelAndView aboutUsPage() {
        return new ModelAndView("about_us");
    }

    @RequestMapping(value = "termsConditions", method = RequestMethod.GET)
    public ModelAndView termsConditionsPage() {
        return new ModelAndView("terms_conditions");
    }

    @RequestMapping(value = "contactUs", method = RequestMethod.GET)
    public ModelAndView contactsPage() {
        return new ModelAndView("contact_us");
    }

}
