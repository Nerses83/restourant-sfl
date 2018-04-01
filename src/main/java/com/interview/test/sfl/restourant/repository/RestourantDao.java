package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestourantDao extends JpaRepository<RestourantTable,Long> {
    List<RestourantTable> findRestourantTablesByUser(User user);
}
