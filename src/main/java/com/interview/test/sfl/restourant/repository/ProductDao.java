package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
}
