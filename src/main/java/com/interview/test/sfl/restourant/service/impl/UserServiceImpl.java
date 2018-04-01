package com.interview.test.sfl.restourant.service.impl;

import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.UserType;
import com.interview.test.sfl.restourant.repository.UserDao;
import com.interview.test.sfl.restourant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public List<User> getWaiters() {
        return userDao.findUserByUserType(UserType.WAITER);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getOne(id);
    }
}
