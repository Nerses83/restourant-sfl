package com.interview.test.sfl.restourant.controller;

import com.interview.test.sfl.restourant.model.Order;
import com.interview.test.sfl.restourant.model.ProductInOrder;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;
import com.interview.test.sfl.restourant.service.OrderService;
import com.interview.test.sfl.restourant.service.ProductInOrderService;
import com.interview.test.sfl.restourant.service.ProductService;
import com.interview.test.sfl.restourant.service.RestourantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RestourantService restourantService;

    @Autowired
    ProductInOrderService productInOrderService;

    @Autowired
    ProductService productService;



    @RequestMapping(value = "/orders/{id}",method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId){
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }



    @RequestMapping(value = "/orders/tables/{table_id}",method = RequestMethod.POST)
    public ResponseEntity<Order> addOrder(@PathVariable("table_id") Long tableId){
        Order oldOrder = null;
        try {
            oldOrder = orderService.findOrderByRestourantTableAndStatus(restourantService.getRestourantTable(tableId),OrderStatus.OPEN);
        }catch (RuntimeException e){
            //
        }
        if(oldOrder != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Order order = new Order(restourantService.getRestourantTable(tableId), OrderStatus.OPEN);
        return new ResponseEntity<>(orderService.save(order),HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{order_id}/products/{product_id}",method = RequestMethod.POST)
    public ResponseEntity<Order> addProductInOrder(@PathVariable("product_id") Long productId, @PathVariable("order_id") Long orderId,
                                  @RequestParam("count") Integer count){
        Order order = orderService.getOrder(orderId);
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(productService.getProduct(productId));
        productInOrder.setCount(count);
        productInOrder.setStatus(OrderStatus.OPEN);
        productInOrderService.save(productInOrder);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{order_id}",method = RequestMethod.PUT)
    public ResponseEntity<Order> changeOrderStatus(@PathVariable("order_id") Long orderId, @RequestParam("status") Integer status){
        Order order = orderService.getOrder(orderId);
        if(status == 2){
            order.setStatus(OrderStatus.CANCELED);
        }else {
            order.setStatus(OrderStatus.CLOSED);
        }
        return new ResponseEntity<>(orderService.save(order),HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/products/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ProductInOrder> editProductInOrder(@PathVariable("id") Long productId, @RequestParam("count") Integer count,
                                   @RequestParam("status") Integer status){
        ProductInOrder productInOrder = productInOrderService.getProductInOrder(productId);
        productInOrder.setCount(count);
        if(status == 2){
            productInOrder.setStatus(OrderStatus.CLOSED);
        }
        return new ResponseEntity<>(productInOrderService.save(productInOrder),HttpStatus.OK);
    }



}
