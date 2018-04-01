package com.interview.test.sfl.restourant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.interview.test.sfl.restourant.model.converter.OrderStatusConverter;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonManagedReference
    RestourantTable restourantTable;

    @Column(name = "status")
    @Convert(converter = OrderStatusConverter.class)
    OrderStatus status;

    @OneToMany(mappedBy = "order")
    Set<ProductInOrder> productInOrders = new HashSet<>();


    public Order() {
    }

    public Order(RestourantTable restourantTable, OrderStatus status) {
        this.restourantTable = restourantTable;
        this.status = status;
    }

    public Order(RestourantTable restourantTable, OrderStatus status, Set<ProductInOrder> productInOrders) {
        this.restourantTable = restourantTable;
        this.status = status;
        this.productInOrders = productInOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestourantTable getRestourantTable() {
        return restourantTable;
    }

    public void setRestourantTable(RestourantTable restourantTable) {
        this.restourantTable = restourantTable;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
