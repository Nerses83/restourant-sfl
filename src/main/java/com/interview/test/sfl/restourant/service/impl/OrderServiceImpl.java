package com.interview.test.sfl.restourant.service.impl;

import com.interview.test.sfl.restourant.model.Order;
import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;
import com.interview.test.sfl.restourant.repository.OrderDao;
import com.interview.test.sfl.restourant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Order save(Order order) {
        return orderDao.saveAndFlush(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderDao.getOne(id);
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order findOrderByRestourantTableAndStatus(RestourantTable restourantTable, OrderStatus orderStatus) {
        return orderDao.findOrderByRestourantTableAndStatus(restourantTable,orderStatus);
    }
}
