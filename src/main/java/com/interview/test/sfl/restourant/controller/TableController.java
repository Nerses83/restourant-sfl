package com.interview.test.sfl.restourant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.test.sfl.restourant.model.Product;
import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.repository.ProductDao;
import com.interview.test.sfl.restourant.repository.RestourantDao;
import com.interview.test.sfl.restourant.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TableController {

    @Autowired
    RestourantDao restourantDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/tables",method = RequestMethod.GET)
    public ResponseEntity<List<RestourantTable>> getTables(){
        return new ResponseEntity<>(restourantDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tables/users/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<RestourantTable>> getTables(@PathVariable("id") Long userId){
        return new ResponseEntity<>(restourantDao.findRestourantTablesByUser(userDao.getOne(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tables/{table_id}/users/{user_id}",method = RequestMethod.PUT )
    public void addTable(@PathVariable("table_id") Long tableId, @PathVariable("user_id") Long userId){
        RestourantTable restourantTable = restourantDao.getOne(tableId);
        restourantTable.setUser(userDao.getOne(userId));
        restourantDao.saveAndFlush(restourantTable);
    }

    @RequestMapping(value = "/tables",method = RequestMethod.POST)
    public void addTable(@RequestParam(name = "name",required = true) String name){
        RestourantTable restourantTable = new RestourantTable();
        restourantTable.setName(name);
        restourantDao.saveAndFlush(restourantTable);
    }

}
