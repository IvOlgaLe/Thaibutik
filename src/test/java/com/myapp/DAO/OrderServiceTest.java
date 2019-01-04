package com.myapp.DAO;

import com.myapp.enums.Constants;
import com.myapp.model.*;
import com.myapp.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class OrderServiceTest extends BaseTestClass {

    @Autowired
    private OrderService orderService;

    public OrderServiceTest(){
    }

    //------OrderDAO----------
    @Test
    public void testCRUDOrder() throws ParseException {
        //-----save------
        OrderState orderState = new OrderState(1, Constants.DELIVERED);
        List<OrderDetail> orderDetailList = new ArrayList<>();

        Date date = format.parse( "2018-11-25" );
        orderDetailList.add(new OrderDetail(0, 100001, "Soap", "Mary Key", 1000001, "Strawberry", "50 ml", 2, new BigDecimal(15.0), 11, ""));
        Order orderExp = new Order(1001, date, new BigDecimal(30.0), 2, 11, date, "Delivery Info", orderState, "147 Main Street", orderDetailList);
        Order order = orderService.saveOrder(orderExp);
        int orderId = order.getId();

        //-----getById-------
        Order orderAct = orderService.getOrderById(orderId);
        Assert.assertEquals(orderExp, orderAct);

        //-----update-----
        orderExp.setDeliveryAddress("158 Main Street Updated");
        orderService.saveOrder(orderExp);

        //-----getAll-----
        List<Order> orderList = orderService.getAllOrders();
        for (Order u: orderList) {
            if(u.getId() == orderId) {
                orderAct = u;
                break;
            }
        }
        Assert.assertEquals(orderExp, orderAct);

        //-----delete-----
        boolean deleteResult = orderService.deleteOrderById(orderId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(orderService.getOrderById(orderId));
    }

    //-----OrderDetailDAO-------
    @Test
    public void testCRUDOrderDetail() {
        //-----save------
        // item (100001, 10.5, 'Type02', '20 ml', 11, 75, 20, 'img06', 20, 1);
        int orderId = 10001;
        int productId = 100001;
        int itemId = 1000002;
        OrderDetail orderDetailExp = new OrderDetail(orderId, productId, "Soap", "Mary Key", itemId,
                "Type02", "20 ml", 1, new BigDecimal(9.5), 11, "img01");
        orderService.saveOrderDetail(orderDetailExp);

        //-----getById-------
        OrderDetail orderDetailAct = orderService.getOrderDetailById(orderId, itemId);
        Assert.assertEquals(orderDetailExp, orderDetailAct);

        //-----update-----
        orderDetailExp.setQuantity(2);
        orderService.saveOrderDetail(orderDetailExp);

        //-----getAll-----
        List<OrderDetail> orderDetailList = orderService.getAllOrderDetails();
        for (OrderDetail c: orderDetailList) {
            if(c.getOrderId() == orderId && c.getItemId() == itemId) {
                orderDetailAct = c;
                break;
            }
        }
        Assert.assertEquals(orderDetailExp, orderDetailAct);

        //-----delete-----
        boolean deleteResult = orderService.deleteOrderDetailById(orderId, itemId);
        Assert.assertTrue(deleteResult);
        Assert.assertNull(orderService.getOrderDetailById(orderId, itemId));
    }

    @Test
    public void testGetOrderByUserId() {
        Map<String, Object> param = new HashMap<>();
        param.put("userId", 1001);
        List<Order> orderList = orderService.getOrderByParam(param);
        Assert.assertEquals(1001, orderList.get(0).getUserId());
    }

    @Test
    public void testGetOrderByTotalPrice() {
        Map<String, Object> param = new HashMap<>();
        param.put("lowTotalPrice", new BigDecimal(10));
        param.put("highTotalPrice", new BigDecimal(40));
        List<Order> orderList = orderService.getOrderByParam(param);
        Assert.assertEquals(1, orderList.size());
    }

    @Test
    public void testGetOrderByOrderStateId() {
        Map<String, Object> param = new HashMap<>();
        param.put("orderStateId", 1);
        List<Order> orderList = orderService.getOrderByParam(param);
        Assert.assertTrue(orderList.get(0).getOrderState().getId() == 1);
    }

    @Test
    public void testGetOrderByDates() throws ParseException {
        Map<String, Object> param = new HashMap<>();
        param.put("beginOrderDate", format.parse( "2018-10-01" ));
        param.put("endOrderDate", format.parse( "2018-12-31" ));
        param.put("beginDeliveryDate", format.parse( "2018-10-01" ));
        param.put("endDeliveryDate", format.parse( "2018-12-20" ));
        List<Order> orderList = orderService.getOrderByParam(param);
        Assert.assertEquals(1, orderList.size());
    }

    @Test
    public void testGetAllOrderOrderBy() throws ParseException {
        Map<String, Object> param = new HashMap<>();
        param.put("orderBy", "order_date");
        List<Order> orderList = orderService.getOrderByParam(param);
        Date date = format.parse( "2018-12-18" );
        Assert.assertEquals(0, orderList.get(0).getOrderDate().compareTo(date));
    }
}
