package com.interview.test.sfl.restourant.service.impl;

import com.interview.test.sfl.restourant.model.ProductInOrder;
import com.interview.test.sfl.restourant.repository.ProductInOrderDao;
import com.interview.test.sfl.restourant.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    ProductInOrderDao productInOrderDao;

    @Override
    public ProductInOrder save(ProductInOrder productInOrder) {
        return productInOrderDao.saveAndFlush(productInOrder);
    }

    @Override
    public ProductInOrder getProductInOrder(Long id) {
        return productInOrderDao.getOne(id);
    }
}
