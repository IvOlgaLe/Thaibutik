package com.myapp.DAO;

import com.myapp.model.Cart;
import com.myapp.model.CartDetail;
import com.myapp.service.CartService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class CartServiceTest extends BaseTestClass {

    @Autowired
    private CartService cartService;

    public CartServiceTest(){
    }

    //------CartDAO----------
    @Test
    public void testCRUDCart() throws ParseException {
        //-----save------
        List<CartDetail> cartDetailList = new ArrayList<>();

        Date date = format.parse( "2018-11-25" );
        cartDetailList.add(new CartDetail(0, 100001, "Soap", "Mary Key", 1000001, "Strawberry", "50 ml", 2, new BigDecimal(15.0), 11, 14, "", "img05"));
        Cart cartExp = new Cart(1001, new BigDecimal(30.0), 2, 11, date, cartDetailList);
        Cart cart = cartService.saveCart(cartExp);
        int cartId = cart.getId();

        //-----getById-------
        Cart cartAct = cartService.getCartById(cartId);
         Assert.assertEquals(cartExp, cartAct);

        //-----update-----
        cartExp.setCartDate(format.parse("2018-12-01"));
        cartService.saveCart(cartExp);

        //-----getAll-----
        List<Cart> cartList = cartService.getAllCarts();
        for (Cart u: cartList) {
            if(u.getId() == cartId) {
                cartAct = u;
                break;
            }
        }
        Assert.assertEquals(cartExp, cartAct);

        //-----delete-----
        boolean deleteCDetailResult = cartService.deleteCartDetailByItemId(1000001);
        Assert.assertTrue(deleteCDetailResult);
        boolean deleteResult = cartService.deleteCartById(cartId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(cartService.getCartById(cartId));
    }

    //-----CartDetailDAO-------
    @Test
    public void testCRUDCartDetail() {
        //-----save------
        // item (100001, 10.5, 'Type02', '20 ml', 11, 75, 20, 'img06', 20, 1);
        int cartId = 10001;
        int productId = 100001;
        int itemId = 1000002;
        CartDetail cartDetailExp = new CartDetail(cartId, productId, "Soap", "Mary Key", itemId,
                "Type02", "20 ml", 1, new BigDecimal(10.5), 11, 20.0, "img01", "img06");
        cartService.saveCartDetail(cartDetailExp);

        //-----getById-------
        CartDetail cartDetailAct = cartService.getCartDetailById(cartId, itemId);
        Assert.assertEquals(cartDetailExp, cartDetailAct);

        //-----update-----
        cartDetailExp.setQuantity(2);
        cartService.saveCartDetail(cartDetailExp);

        //-----getAll-----
        List<CartDetail> cartDetailList = cartService.getAllCartDetails();
        for (CartDetail c: cartDetailList) {
            if(c.getCartId() == cartId && c.getItemId() == itemId) {
                cartDetailAct = c;
                break;
            }
        }
        Assert.assertEquals(cartDetailExp, cartDetailAct);

        //-----delete-----
        cartService.deleteCartDetailById(cartId, itemId);
        Assert.assertNull(cartService.getCartDetailById(cartId, itemId));
    }

    @Test
    public void testGetCartByUserId() {
        Cart cart = cartService.getCartByUserId(1001);
        Assert.assertEquals(1001, cart.getUserId());

        Map<String, Object> param = new HashMap<>();
        param.put("userId", 1001);
        List<Cart> cartList = cartService.getCartByParam(param);
        Assert.assertEquals(1001, cartList.get(0).getUserId());
    }

    @Test
    public void testGetCartByTotalPrice() {
        Map<String, Object> param = new HashMap<>();
        param.put("lowTotalPrice", new BigDecimal(30));
        param.put("highTotalPrice", new BigDecimal(40));
        List<Cart> cartList = cartService.getCartByParam(param);
        Assert.assertEquals(1, cartList.size());
    }

    @Test
    public void testGetCartByDates() throws ParseException {
        Map<String, Object> param = new HashMap<>();
        param.put("beginCartDate", format.parse( "2018-10-01" ));
        param.put("endCartDate", format.parse( "2018-12-31" ));
        List<Cart> cartList = cartService.getCartByParam(param);
        Assert.assertEquals(1, cartList.size());
    }

    @Test
    public void testGetAllCartCartBy() throws ParseException {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "cart_date");
        List<Cart> cartList = cartService.getCartByParam(param);
        Date date = format.parse( "2018-11-17" );
        Assert.assertEquals(0, cartList.get(0).getCartDate().compareTo(date));
    }
}
