package com.interview.test.sfl.restourant.service;

import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.User;

import java.util.List;

public interface RestourantService {
    List<RestourantTable> findRestourantTablesByUser(User user);
    RestourantTable getRestourantTable(Long id);
    List<RestourantTable> getRestourantTables();
    RestourantTable save(RestourantTable restourantTable);
}
