package com.myapp.service;

import com.myapp.DAO.OrderDAO;
import com.myapp.DAO.OrderDetailDAO;
import com.myapp.model.Order;
import com.myapp.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

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

    public List<Order> getOrdersByParam(Map<String, Object> param) {
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

    public List<OrderDetail> getOrderDetailsByParam(Map<String, String> param) {
        return orderDetailDAO.getOrderDetailsByParam(param);
    }
}
