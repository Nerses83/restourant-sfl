package com.interview.test.sfl.restourant.controller;

import com.interview.test.sfl.restourant.model.Product;
import com.interview.test.sfl.restourant.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public void addProduct(){
        Product product = new Product("First Product",200.20);
        productDao.saveAndFlush(product);
    }
}
