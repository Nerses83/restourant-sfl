package com.interview.test.sfl.restourant.service;

import com.interview.test.sfl.restourant.model.Product;

public interface ProductService {
    Product save(Product product);
    Product getProduct(Long id);
}
