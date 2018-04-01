package com.interview.test.sfl.restourant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.test.sfl.restourant.model.converter.UserTypeConverter;
import com.interview.test.sfl.restourant.model.enums.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;


    @Column(name = "type")
    @Convert(converter = UserTypeConverter.class)
    UserType userType;

    @Column(name = "full_name")
    String fullName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    Set<RestourantTable> restourantTables = new HashSet<>();

    public User() {
    }

    public User(UserType userType, String fullName) {
        this.userType = userType;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<RestourantTable> getRestourantTables() {
        return restourantTables;
    }

    public void setRestourantTables(Set<RestourantTable> restourantTables) {
        this.restourantTables = restourantTables;
    }
}
