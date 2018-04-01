package com.interview.test.sfl.restourant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Restourant_Table")
public class RestourantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    User user;

    @OneToMany(mappedBy = "restourantTable")
    @JsonBackReference
    Set<Order> orders = new HashSet<>();

    String name;

    public RestourantTable() {
    }

    public RestourantTable(User user, Set<Order> orders, String name) {
        this.user = user;
        this.orders = orders;
    }

    public RestourantTable(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
