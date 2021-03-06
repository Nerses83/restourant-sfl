package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.Order;
import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
    Order findOrderByRestourantTableAndStatus(RestourantTable restourantTable, OrderStatus orderStatus);
}
