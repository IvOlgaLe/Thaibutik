package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController extends BaseController {

  /*  @Autowired
    UserService userService;
*//*
	@Autowired
	RoleService roleService;
	
	@Autowired
	OrderService orderService;*/


/*    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage() {
        return "mainPage";
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showMainPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("cartItemsNumber", 2);
        session.setAttribute("cartTotalPrice", 15);
        session.setAttribute("categoryName", "Skincare");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "Index", method = RequestMethod.GET)
    public ModelAndView indexPage() {

        return new ModelAndView("index");
    }

    @RequestMapping(value = "Checkout", method = RequestMethod.GET)
    public ModelAndView checkoutPage() {
        return new ModelAndView("checkout");
    }

    @RequestMapping(value = "AboutUs", method = RequestMethod.GET)
    public ModelAndView aboutUsPage() {
        return new ModelAndView("about_us");
    }

    @RequestMapping(value = "ShoppingCart", method = RequestMethod.GET)
    public ModelAndView shoppingCartPage() {
        return new ModelAndView("shopping_cart");
    }

    @RequestMapping(value = "WishList", method = RequestMethod.GET)
    public ModelAndView wishListPage() {
        return new ModelAndView("wish_list");
    }

    @RequestMapping(value = "TermsConditions", method = RequestMethod.GET)
    public ModelAndView termsConditionsPage() {
        return new ModelAndView("terms_conditions");
    }

    @RequestMapping(value = "ContactUs", method = RequestMethod.GET)
    public ModelAndView contactsPage() {
        return new ModelAndView("contact_us");
    }

    @RequestMapping(value = "OrderList", method = RequestMethod.GET)
    public ModelAndView ordersPage() {
        return new ModelAndView("order_list");
    }
}
