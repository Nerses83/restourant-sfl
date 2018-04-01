package com.interview.test.sfl.restourant.service;

import com.interview.test.sfl.restourant.model.ProductInOrder;

public interface ProductInOrderService {
    ProductInOrder save(ProductInOrder productInOrder);
    ProductInOrder getProductInOrder(Long id);
}
