package com.interview.test.sfl.restourant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.interview.test.sfl.restourant.model.converter.OrderStatusConverter;
import com.interview.test.sfl.restourant.model.enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_IN_TABLE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "status")
    @Convert(converter = OrderStatusConverter.class)
    OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    Integer count;


    public ProductInOrder() {
    }

    public ProductInOrder(OrderStatus status, Order order, Product product, Integer count) {
        this.status = status;
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
