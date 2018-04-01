package com.interview.test.sfl.restourant.controller;


import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.UserType;
import com.interview.test.sfl.restourant.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController  {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public void addUser(@RequestParam(name = "name",required = true) String name, @RequestParam(name = "role",required = true) int type){
        User user = new User();
        user.setFullName(name);
        if(type == 1){
            user.setUserType(UserType.MANAGER);
        }else {
            user.setUserType(UserType.WAITER);
        }
        userDao.saveAndFlush(user);
    }
}
