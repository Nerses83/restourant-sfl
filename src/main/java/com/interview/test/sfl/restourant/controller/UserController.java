package com.interview.test.sfl.restourant.controller;


import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.UserType;
import com.interview.test.sfl.restourant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController  {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestParam(name = "name",required = true) String name, @RequestParam(name = "role",required = true) int type){
        User user = new User();
        user.setFullName(name);
        if(type == 1){
            user.setUserType(UserType.MANAGER);
        }else {
            user.setUserType(UserType.WAITER);
        }
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);

    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getWaiters(){
        return new ResponseEntity<>(userService.getWaiters(), HttpStatus.OK);

    }
}
