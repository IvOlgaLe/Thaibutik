package com.myapp.service;

import com.myapp.DAO.OrderDAO;
import com.myapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    public Order saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }

    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    public boolean deleteOrderById(int id) {
        return orderDAO.deleteOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public List<Order> getOrderByUserId(int userId) {
        return orderDAO.getOrderByUserId(userId);
    }

    public List<Order> getOrderByOStateId(int oStateId) {
        return orderDAO.getOrderByOStateId(oStateId);
    }

    public List<Order> getOrderByDate(Date fDate, Date sDate) {
        return orderDAO.getOrderByDate(fDate, sDate);
    }

    public List<Order> getOrderByDeliveryDate(Date fDate, Date sDate) {
        return orderDAO.getOrderByDeliveryDate(fDate, sDate);
    }

    public List<Order> getOrdersByParam(Map<String, String> param) {
        return null;
    }

}
