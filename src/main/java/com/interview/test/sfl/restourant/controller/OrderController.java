package com.interview.test.sfl.restourant.controller;

import com.interview.test.sfl.restourant.model.Order;
import com.interview.test.sfl.restourant.model.Product;
import com.interview.test.sfl.restourant.model.ProductInOrder;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;
import com.interview.test.sfl.restourant.repository.OrderDao;
import com.interview.test.sfl.restourant.repository.ProductDao;
import com.interview.test.sfl.restourant.repository.ProductInOrderDao;
import com.interview.test.sfl.restourant.repository.RestourantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @Autowired
    RestourantDao restourantDao;

    @Autowired
    ProductInOrderDao productInOrderDao;

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "/orders/tables/{table_id}",method = RequestMethod.GET)
    public void addOrder(@PathVariable("table_id") Long tableId){
        Order order = new Order(restourantDao.getOne(tableId), OrderStatus.OPEN);
        orderDao.saveAndFlush(order);
    }

    @RequestMapping(value = "/orders/{order_id}/products/{product_id}",method = RequestMethod.GET)
    public void addProductInOrder(@PathVariable("product_id") Long productId, @PathVariable("order_id") Long orderId){
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(orderDao.getOne(orderId));
        productInOrder.setProduct(productDao.getOne(productId));
        productInOrder.setCount(2);
        productInOrder.setStatus(OrderStatus.OPEN);
        productInOrderDao.saveAndFlush(productInOrder);
    }

}
