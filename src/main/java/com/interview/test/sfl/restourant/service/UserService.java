package com.interview.test.sfl.restourant.service;

import com.interview.test.sfl.restourant.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User getUser(Long id);



    List<User> getWaiters();
}
