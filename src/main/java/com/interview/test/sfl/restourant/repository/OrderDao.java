package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
