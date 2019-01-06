package com.myapp.service;

import com.myapp.DAO.OrderDAO;
import com.myapp.DAO.OrderDetailDAO;
import com.myapp.DAO.OrderStateDAO;
import com.myapp.enums.Constants;
import com.myapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Autowired
    OrderStateDAO orderStateDAO;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    public Order saveOrder(Order order) {
        Order result = orderDAO.saveOrder(order);
        if (result != null) {
            List<OrderDetail> orderDetailList = order.getOrderDetailList();
            for (OrderDetail orderDetail : orderDetailList) {
                orderDetail.setOrderId(result.getId());
                saveOrderDetail(orderDetail);
            }
        }
        return result;
    }

    //----OrderDAO-------
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    public boolean deleteOrderById(int id) {
        return orderDetailDAO.deleteOrderDetailByOrderId(id) && orderDAO.deleteOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public List<Order> getOrderByParam(Map<String, Object> param) {
        return orderDAO.getOrderByParam(param);
    }

    //-----OrderDetailDAO------
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailDAO.saveOrderDetail(orderDetail);
    }

    public boolean deleteOrderDetailByOrderId(int orderId) {
        return orderDetailDAO.deleteOrderDetailByOrderId(orderId);
    }

    public boolean deleteOrderDetailById(int orderId, int itemId) {
        return orderDetailDAO.deleteOrderDetailById(orderId, itemId);
    }

    public OrderDetail getOrderDetailById(int orderId, int itemId) {
        return orderDetailDAO.getOrderDetailById(orderId, itemId);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailDAO.getAllOrderDetails();
    }

    public List<OrderDetail> getOrderDetailsByParam(Map<String, Object> param) {
        return orderDetailDAO.getOrderDetailsByParam(param);
    }

    //------OrderState-------
    public List<OrderState> getAllOrderStates() {
        return orderStateDAO.getAllOrderStates();
    }

    public OrderState getOrderStateById(int id) {
        return orderStateDAO.getOrderStateById(id);
    }

    public OrderState getOrderStateByName(String name) {
        return orderStateDAO.getOrderStateByName(name);
    }

    public boolean deleteOrderStateById(int id) {
        return orderStateDAO.deleteOrderStateById(id);
    }

    /**
     * The method
     *
     * @param request
     * @param exceptionList
     * @return
     */
    public Order placeOrder(HttpServletRequest request, List<Exception> exceptionList) {
        HttpSession session = request.getSession();

        Order order = new Order();
        order.setUserId(((User) session.getAttribute("sessUser")).getId());
        order.setOrderDate(new Date());
        order.setOrderState(getOrderStateByName(Constants.PROCESSING));
        order.setDeliveryInfo(request.getParameter("deliveryInfo"));
        order.setDeliveryInfo(request.getParameter("deliveryAddress"));

        Cart cart = (Cart) session.getAttribute("cart");
        order.setCurrencyId(cart.getCurrencyId());
        order.setTotalQuantity(cart.getTotalQuantity());
        order.setTotalPrice(cart.getTotalPrice()
        );
        List<OrderDetail> orderDetailList = new ArrayList<>();
        //for update item quantity
        List<Item> soldItems = new ArrayList<>();
        for (CartDetail cartDetail : cart.getCartDetailList()) {
            OrderDetail orderDetail = new OrderDetail();
            int itemId = cartDetail.getItemId();
            int quantity = cartDetail.getQuantity();

            //check item availability and calculate quantity
            Item item = productService.getItemUpdatedQuantity(itemId, quantity, exceptionList);
            if (item == null) {
                break;
            } else {
                soldItems.add(item);
            }
            orderDetail.setItemId(itemId);
            BigDecimal priceWithDiscount = (cartDetail.getPrice().multiply(new BigDecimal(1.0 - cartDetail.getDiscount() / 100)))
                    .setScale(2, RoundingMode.HALF_EVEN);
            orderDetail.setPrice(priceWithDiscount);
            orderDetail.setCurrencyId(cartDetail.getCurrencyId());
            orderDetail.setQuantity(quantity);

            orderDetailList.add(orderDetail);
        }
        order.setOrderDetailList(orderDetailList);

        if (exceptionList.isEmpty()) {
            for (Item item : soldItems) {
                productService.saveItem(item);
            }
            //clear user's shopping cart
            cartService.deleteCartDetailByCartId(cart.getId());
            session.setAttribute("cart", cartService.recalcTotals(cartService.getCartById(cart.getId())));
            return saveOrder(order);
        } else return null;
    }

    public Order updateOrder(int orderId, HttpServletRequest request, List<Exception> exceptionList) throws ParseException {
        Order order = getOrderById(orderId);
        if(request.getParameter("deliveryDate") != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(request.getParameter("deliveryDate"));
            order.setDeliveryDate(date);
        }
        order.setOrderState(getOrderStateById(Integer.valueOf(request.getParameter("orderStateId"))));
        return saveOrder(order);
    }
}
