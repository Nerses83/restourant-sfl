package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderDao extends JpaRepository<ProductInOrder,Long> {
}
