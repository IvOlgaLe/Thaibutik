package com.myapp.controller;

import com.myapp.model.Cart;
import com.myapp.model.CartDetail;
import com.myapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController extends BaseController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "shoppingCart", method = RequestMethod.GET)
    public ModelAndView shoppingCartPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int cartId = session.getAttribute("cart") != null ? ((Cart) session.getAttribute("cart")).getId() : 0;
        Cart cart = cartId != 0 ? cartService.getCartById(cartId) : null;
        cart = cart != null ? cartService.recalcTotals(cart) : null;
        session.setAttribute("cart", cart);
        return new ModelAndView("shopping_cart");
    }

    @RequestMapping(value = "addToCart/{itemId}", method = RequestMethod.GET)
    public String AddToCartPage(
            @PathVariable("itemId") int itemId, HttpServletRequest request, RedirectAttributes redir) {
        List<Exception> exceptionList = new ArrayList<>();
        HttpSession session = request.getSession();
        int quantity = Integer.valueOf(request.getParameter("itemQuantity"));
        Cart cart = cartService.getUserCart(session);
        session.setAttribute("cart", cartService.addItemToCart(cart, itemId, quantity, exceptionList));
        redir.addFlashAttribute("exceptionList", exceptionList);
        return "redirect:/shoppingCart";
    }

    @RequestMapping(value = "deleteItemFromCart/{itemId}", method = RequestMethod.GET)
    public String DeleteItemFromCart(
            @PathVariable("itemId") int itemId, HttpServletRequest request, RedirectAttributes redir) {
        List<Exception> exceptionList = new ArrayList<>();
        int cartId = ((Cart) request.getSession().getAttribute("cart")).getId();
        cartService.deleteCartDetailById(cartId, itemId);
        redir.addFlashAttribute("exceptionList", exceptionList);
        return "redirect:/shoppingCart";
    }

    @RequestMapping(value = "changeCartDetail", method = RequestMethod.GET)
    public String changeCartDetail(RedirectAttributes redir,
                                   @ModelAttribute CartDetail cartDetail) {
        List<Exception> exceptionList = new ArrayList<>();
        int itemId = cartDetail.getItemId();
        int quantity = cartDetail.getQuantity();
        cartDetail.setQuantity(cartService.checkAvailability(itemId, quantity, exceptionList));
        redir.addFlashAttribute("exceptionList", exceptionList);
        cartService.saveCartDetail(cartDetail);
        return "redirect:/shoppingCart";
    }
}
