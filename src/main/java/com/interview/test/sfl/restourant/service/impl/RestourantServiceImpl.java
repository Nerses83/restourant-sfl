package com.interview.test.sfl.restourant.service.impl;

import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.repository.RestourantDao;
import com.interview.test.sfl.restourant.service.RestourantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestourantServiceImpl implements RestourantService {

    @Autowired
    RestourantDao restourantDao;

    @Override
    public List<RestourantTable> findRestourantTablesByUser(User user) {
        return restourantDao.findRestourantTablesByUser(user);
    }

    @Override
    public RestourantTable getRestourantTable(Long id) {
        return restourantDao.getOne(id);
    }

    @Override
    public List<RestourantTable> getRestourantTables() {
        return restourantDao.findAll();
    }

    @Override
    public RestourantTable save(RestourantTable restourantTable) {
        return restourantDao.saveAndFlush(restourantTable);
    }
}
