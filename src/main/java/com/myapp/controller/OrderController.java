package com.myapp.controller;

import com.myapp.model.Cart;
import com.myapp.model.Order;
import com.myapp.model.User;
import com.myapp.service.CartService;
import com.myapp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.*;

@Controller
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;


    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public ModelAndView checkoutPage(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("sessUser") == null) {
            return new ModelAndView("login");
        } else if (session.getAttribute("cart") == null ||
                ((Cart) session.getAttribute("cart")).getCartDetailList() == null ||
                ((Cart) session.getAttribute("cart")).getCartDetailList().isEmpty()) {
            return new ModelAndView("shopping_cart");
        } else {
            return new ModelAndView("checkout");
        }
    }

    @RequestMapping(value = "processPlaceOrder", method = RequestMethod.GET)
    public String processPlaceOrder(HttpServletRequest request,
                                    RedirectAttributes redir) {
        List<Exception> exceptionList = new ArrayList<>();
        Order order = orderService.placeOrder(request, exceptionList);
        if (order == null) {
            redir.addFlashAttribute("exceptionList", exceptionList);
            return "redirect:/myOrderList";
        }
        return "redirect:/myOrderList";
    }

    @RequestMapping(value = "myOrderList", method = RequestMethod.GET)
    public ModelAndView myOrdersPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("sessUser") == null) {
            return new ModelAndView("login");
        } else {
            Map<String, Object> param = new HashMap<>();
            param.put("userId", ((User) session.getAttribute("sessUser")).getId());
            param.put("orderBy", "order_date DESC");
            request.setAttribute("orderList", orderService.getOrderByParam(param));
            return new ModelAndView("my_order_list");
        }
    }

    @RequestMapping(value = "wishList", method = RequestMethod.GET)
    public ModelAndView wishListPage() {
        return new ModelAndView("wish_list");
    }

    @RequestMapping(value = "orderTable", method = RequestMethod.GET)
    public ModelAndView orderTablePage(HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "o.order_date DESC");
        request.setAttribute("orderList", orderService.getOrderByParam(param));
        return new ModelAndView("order_table");
    }

    @RequestMapping(value = "orderDetailTable/{orderId}", method = RequestMethod.GET)
    public ModelAndView orderDetailTablePage(
            @PathVariable("orderId") int orderId,
            HttpServletRequest request) {
        request.setAttribute("order", orderService.getOrderById(orderId));
        return new ModelAndView("order_detail_table");
    }

    @RequestMapping(value = "processEditOrder/{orderId}", method = RequestMethod.GET)
    public String processEditItem(
            @PathVariable("orderId") int orderId,
            HttpServletRequest request,
            RedirectAttributes redir) throws ParseException {
        List<Exception> exceptionList = new ArrayList<>();
        orderService.updateOrder(orderId, request, exceptionList);
        redir.addFlashAttribute("exceptionList", exceptionList);
        return "redirect:/orderTable";
    }
}
