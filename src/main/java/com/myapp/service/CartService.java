package com.myapp.service;

import com.myapp.DAO.CartDAO;
import com.myapp.DAO.CartDetailDAO;
import com.myapp.exception.NotAvailableItemException;
import com.myapp.model.Cart;
import com.myapp.model.CartDetail;
import com.myapp.model.Item;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartDetailDAO cartDetailDAO;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    ProductService productService;

    //----CartDAO-------
    public Cart saveCart(Cart cart) {
        Cart result = cartDAO.saveCart(cart);
        if (result != null) {
            List<CartDetail> cartDetailList = cart.getCartDetailList() != null ?
                    cart.getCartDetailList() : new ArrayList<>();
            for (CartDetail cartDetail : cartDetailList) {
                cartDetail.setCartId(result.getId());
                saveCartDetail(cartDetail);
            }
        }
        return result;
    }

    public Cart getCartById(int id) {
        return cartDAO.getCartById(id);
    }

    public Cart getCartByUserId(int userId) {
        return cartDAO.getCartByUserId(userId);
    }

    public boolean deleteCartById(int id) {
        cartDetailDAO.deleteCartDetailByCartId(id);
        return cartDAO.deleteCartById(id);
    }

    public List<Cart> getAllCarts() {
        return cartDAO.getAllCarts();
    }

    public List<Cart> getCartByParam(Map<String, Object> param) {
        return cartDAO.getCartByParam(param);
    }

    //-----CartDetailDAO------
    public CartDetail saveCartDetail(CartDetail cartDetail) {
        return cartDetailDAO.saveCartDetail(cartDetail);
    }

    public Cart deleteCartDetailById(int cartId, int itemId) {
        boolean deleteResult = cartDetailDAO.deleteCartDetailById(cartId, itemId);
        Cart cart = cartDAO.getCartById(cartId);
        if (deleteResult) {
            cart.setTotalQuantity(calcTotalQuantity(cart));
            cart.setTotalPrice(calcTotalPrice(cart));
        }
        return saveCart(cart);
    }

    public boolean deleteCartDetailByCartId(int cartId) {
        return cartDetailDAO.deleteCartDetailByCartId(cartId);
    }

    public boolean deleteCartDetailByItemId(int itemId) {
        return cartDetailDAO.deleteCartDetailByItemId(itemId);
    }

    public CartDetail getCartDetailById(int cartId, int itemId) {
        return cartDetailDAO.getCartDetailById(cartId, itemId);
    }

    public List<CartDetail> getAllCartDetails() {
        return cartDetailDAO.getAllCartDetails();
    }

    public List<CartDetail> getCartDetailsByParam(Map<String, String> param) {
        return cartDetailDAO.getCartDetailsByParam(param);
    }


    public Cart addItemToCart(Cart cart, int itemId, int quantity, List<Exception> exceptionList) {
        List<CartDetail> cartDetailList = cart.getCartDetailList() != null ? cart.getCartDetailList() : new ArrayList<>();
        boolean inCart = false;
        for (CartDetail cartDetail : cartDetailList) {
            if (cartDetail.getItemId() == itemId) {
                quantity = cartDetail.getQuantity() + quantity;
                quantity = checkAvailability(itemId, quantity, exceptionList);
                cartDetail.setQuantity(quantity);
                inCart = true;
                break;
            }
        }
        if (!inCart) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setItemId(itemId);
            quantity = checkAvailability(itemId, quantity, exceptionList);
            cartDetail.setQuantity(quantity);
            cartDetailList.add(cartDetail);
        }
        cart.setCartDetailList(cartDetailList);
        return saveCart(cart);
    }

    public Cart recalcTotals(Cart cart) {
        int totalQuantity = calcTotalQuantity(cart);
        BigDecimal totalPrice = calcTotalPrice(cart);
        if (totalQuantity != cart.getTotalQuantity() || totalPrice.compareTo(cart.getTotalPrice()) != 0) {
            cart.setTotalQuantity(totalQuantity);
            cart.setTotalPrice(totalPrice);
            return saveCart(cart);
        } else return cart;
    }

    public Cart getUserCart(HttpSession session) {
        Cart cart;
        if (session.getAttribute("cart") != null) {
            int cartId = ((Cart) session.getAttribute("cart")).getId();
            cart = getCartById(cartId);
        } else {                     //first time
            int currencyID = currencyService.getDefaultCurrencyId();
            cart = saveCart(new Cart(0, new BigDecimal(0), 0, currencyID, new Date(), null));
        }
        session.setAttribute("cart", cart);
        return cart;
    }

    public BigDecimal calcTotalPrice(Cart cart) {
        BigDecimal totalPrice = new BigDecimal(0);
        List<CartDetail> cartDetailList = cart.getCartDetailList() != null ? cart.getCartDetailList() : new ArrayList<>();
        for (CartDetail cartDetail : cartDetailList) {
            BigDecimal priceWithDiscount = (cartDetail.getPrice().multiply(new BigDecimal(1.0 - cartDetail.getDiscount() / 100)))
                    .setScale(2, RoundingMode.HALF_EVEN);
            int quantity = cartDetail.getQuantity();
            BigDecimal rate = currencyService.getCurrencyRate(cartDetail.getCurrencyId());
            totalPrice = totalPrice.add(priceWithDiscount.multiply(new BigDecimal(quantity)).multiply(rate));
        }
        return totalPrice;
    }

    public int calcTotalQuantity(Cart cart) {
        int totalQuantity = 0;
        List<CartDetail> cartDetailList = cart.getCartDetailList() != null ? cart.getCartDetailList() : new ArrayList<>();
        for (CartDetail cartDetail : cartDetailList) {
            totalQuantity = totalQuantity + cartDetail.getQuantity();
        }
        return totalQuantity;
    }

    public Cart mergeLoginUserCarts(HttpSession session, List<Exception> exceptionList) {
        int currencyID = currencyService.getDefaultCurrencyId();
        int userId = ((User) session.getAttribute("sessUser")).getId();
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = getCartByUserId(userId) != null ? getCartByUserId(userId) :
                    saveCart(new Cart(userId, new BigDecimal(0), 0, currencyID, new Date(), null));
        } else if (getCartByUserId(userId) == null) {
            cart = (Cart) session.getAttribute("cart");
            cart.setUserId(userId);
            saveCart(cart);
        } else {
            int cartId = ((Cart) session.getAttribute("cart")).getId();
            Cart sessionCart = getCartById(cartId);
            Cart userCart = getCartByUserId(userId);
            if (sessionCart.getCartDetailList() != null && userCart.getCartDetailList() != null) {
                for (CartDetail cartDetail : sessionCart.getCartDetailList()) {
                    addItemToCart(userCart, cartDetail.getItemId(), cartDetail.getQuantity(), exceptionList);
                }
                cart = userCart;
            } else if (sessionCart.getCartDetailList() == null) {
                cart = userCart;
            } else {
                cart = sessionCart;
            }
        }
        session.setAttribute("cart", cart);
        return cart;
    }

    public int checkAvailability(int itemId, int quantity, List<Exception> exceptionList) {
        Item item = productService.getItemById(itemId);
        if (item.getAvailable()) {
            if (item.getQuantity() >= quantity) {
                return quantity;
            } else {
                exceptionList.add(new NotAvailableItemException("Unfortunately, there are " + item.getQuantity() + " items in stock"));
                return item.getQuantity();
            }
        } else {
            exceptionList.add(new NotAvailableItemException("Unfortunately, this product is not available"));
            return 0;
        }
    }

    public Item getItemUpdatedQuantity(int itemId, int quantity, List<Exception> exceptionList) {
        Item item = productService.getItemById(itemId);
        if (item.getAvailable()) {
            if (item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
                item.setQuantOrdered(item.getQuantOrdered() + quantity);
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
}