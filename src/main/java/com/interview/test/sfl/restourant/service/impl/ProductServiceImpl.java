package com.interview.test.sfl.restourant.service.impl;

import com.interview.test.sfl.restourant.model.Product;
import com.interview.test.sfl.restourant.repository.ProductDao;
import com.interview.test.sfl.restourant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.saveAndFlush(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getOne(id);
    }
}
