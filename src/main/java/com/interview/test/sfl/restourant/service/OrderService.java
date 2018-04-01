package com.interview.test.sfl.restourant.service;

import com.interview.test.sfl.restourant.model.Order;
import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;

import java.util.List;


public interface OrderService {
    Order save(Order order);
    Order getOrder(Long id);
    List<Order> getOrders();
    Order findOrderByRestourantTableAndStatus(RestourantTable restourantTable, OrderStatus orderStatus);
}
