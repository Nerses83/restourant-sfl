package com.interview.test.sfl.restourant.controller;

import com.interview.test.sfl.restourant.model.Product;
import com.interview.test.sfl.restourant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestParam("name") String name, @RequestParam("price") Double price){
        Product product = new Product(name,price);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
}
